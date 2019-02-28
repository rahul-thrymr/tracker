package com.handler.tracker.securityHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * To load User Details from do and For Setting User Authentication in security context
 *
 * the database hit in the above filter is optional.
 * You could also encode the user’s username and roles inside JWT claims and
 * create the UserDetails object by parsing those claims from the JWT. That would avoid the database hit.
 *
 * However, Loading the current details of the user from the database might still be helpful.
 * For example, you might wanna disallow login with this JWT if the user’s role has changed,
 * or the user has updated his password after the creation of this JWT.
 */

public class AuthenticationFilter extends OncePerRequestFilter {

  @Autowired
  private JwtTokenProvider tokenProvider;

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    try {
      String jwt = getJwtFromRequest(request);

      if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
        Long userId = tokenProvider.getUserIdFromJWT(jwt);

        UserDetails userDetails = customUserDetailsService.loadUserById(userId);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    } catch (Exception e) {
      System.out.println("Could not set user authentication in security context" + e);
    }
    filterChain.doFilter(request, response);
  }

  /**
   * Retrive authorization token from header
   * @param request
   * @return
   */
  private String getJwtFromRequest(HttpServletRequest request) {
    String bearerToken = request.getHeader("AUthorization");
    if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }
    return null;
  }
}
