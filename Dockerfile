FROM eclipse-temurin:17-jre-alpine
MAINTAINER bhushan.padhye@icloud.com
COPY target/colors-*.jar colors.jar
ENTRYPOINT ["java","-jar","/colors.jar","--color=orange","--message='Test Message'"]