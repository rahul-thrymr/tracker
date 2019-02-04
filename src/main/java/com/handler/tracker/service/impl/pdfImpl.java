package com.handler.tracker.service.impl;

import com.handler.tracker.repo.TestRepo;
import com.handler.tracker.service.PdfService;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class pdfImpl implements PdfService {


  TestRepo testRepo;

  public void createPdf() {
    System.out.println("autowire");
  }

  public void testre() {
    System.out.println("resource");
  }

  @Override
  public void testre1() {
  /*  List<RegistrationDetails> all = testRepo.findAll();
    all.forEach(System.out::println);}*/

    try {
      FFmpeg fFmpeg = new FFmpeg("/usr/bin/ffmpeg");
      System.out.println(fFmpeg.isFFmpeg()+"-----------------");
      FFprobe fFprobe = new FFprobe("/usr/bin/ffprobe");
      System.out.println(fFprobe.isFFprobe()+"====================");
    } catch (IOException e) {
      e.printStackTrace();
    }

    SolrClient server = new HttpSolrClient.Builder("http://my_solr:8984/solr/testcore").build();
    SolrQuery solrQuery = new SolrQuery();
    solrQuery.setQuery("*:*");
    long count = 0;
    try {
      System.out.println(server.query(solrQuery).getResults());
      count = server.query(solrQuery).getResults().getNumFound();
    } catch (SolrServerException | IOException e) {
      e.printStackTrace();
    }
//    return "yuppieeee";

  }

  /*public void createPdf() throws Exception {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream("/home/thrymr/test.pdf"));
    document.open();
    Font font=new Font(Font.FontFamily.TIMES_ROMAN,13.0f,Font.BOLD, BaseColor.BLACK);
    Paragraph title = new Paragraph("VED International School",font);
    title.setAlignment(Element.ALIGN_CENTER);
    document.add(title);
    Paragraph addr1 = new Paragraph("Affiliated to C.B.S.E ( 10+2 ) New Delhi");
    addr1.setAlignment(Element.ALIGN_CENTER);
    document.add(addr1);
    Paragraph addr2 = new Paragraph("NH-29, Basupur, Saidpur, Ghazipur – 233304");
    addr2.setAlignment(Element.ALIGN_CENTER);
    document.add(addr2);
    Paragraph addr3 = new Paragraph("Contact – 8795830440, 8795830441");
    addr3.setAlignment(Element.ALIGN_CENTER);
    document.add(addr3);
    Image image = Image.getInstance("/home/thrymr/projects/tracker/src/main/resources/pubg.jpg");
    image.setAbsolutePosition(120,750);
    image.scaleToFit(40,40);
    document.add(image);
    document.close();
  }*/


}
