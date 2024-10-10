FROM openjdk:17-jdk-slim

LABEL maintainer="mohamediagana mohameddiagana807@gmail.com"

EXPOSE 7075

ADD target/GestionCliniqueKissi.jar GestionCliniqueKissi.jar

# Run the application.
ENTRYPOINT ["ng", "server","--host","0.0.0.0", "--disable-host-checked"]