FROM amazoncorretto:17.0.6-alpine3.17
MAINTAINER bhushan.padhye@icloud.com
COPY target/colors-*.jar colors.jar
ENTRYPOINT ["java","-jar","/colors.jar"]