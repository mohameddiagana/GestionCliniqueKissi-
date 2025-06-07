FROM openjdk:17-jdk-slim

LABEL maintainer="mohamediagana mohameddiagana807@gmail.com"
WORKDIR /build

COPY target/GestionCliniqueKissi.jar GestionCliniqueKissi.jar/

COPY . ./
EXPOSE 8135

#ADD target/GestionCliniqueKissi.jar GestionCliniqueKissi.jar

# Run the application.
ENTRYPOINT ["java" , " -jar" , "GestionCliniqueKissi.jar"]
#gestioncliniquekissi:0.0.1
#CMD