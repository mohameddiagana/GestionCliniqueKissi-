FROM openjdk:17-jdk-slim

LABEL maintainer="mohamediagana mohameddiagana807@gmail.com"

EXPOSE 7075

RUN mkdir -p /var/lib/pgadmin

ADD target/GestionCliniqueKissi.jar GestionCliniqueKissi.jar

ENTRYPOINT ["java", "-jar", "GestionCliniqueKissi.jar"]