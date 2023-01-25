FROM amazoncorretto:17.0.6-alpine3.17
MAINTAINER bhushan.padhye@icloud.com
COPY target/colors-0.0.1.jar colors.jar
ENTRYPOINT ["java","-jar","/colors.jar"]