#FROM ubuntu:16.04
#RUN apt-get update
#RUN apt-get install -y ffmpeg
#RUN apt-get install -y openjdk-8-jdk
#COPY target/tracker-test.jar /tmp/

FROM openjdk:8
ADD target/tracker-test.jar opt/tracker-test.jar
RUN apt-get update
RUN apt-get install -y ffmpeg
#COPY ffmpeg/ffmpeg usr/bin/ffmpeg
EXPOSE 8081
CMD ["java", "-jar", "opt/tracker-test.jar"]