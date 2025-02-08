FROM openjdk:17-jdk-slim

LABEL maintainer="mohamediagana mohameddiagana807@gmail.com"

#WORKDIR /webapp
#
#COPY . .
#
#RUN npm cache clean --force && npm install -f && npm run build
#
#FROM nginx:alpine
#
#COPY nginx.conf /etc/nginx/nginx.conf

EXPOSE 7075

ADD target/GestionCliniqueKissi.jar GestionCliniqueKissi.jar

# Run the application.
ENTRYPOINT ["ng", "server","--host","0.0.0.0", "--disable-host-checked"]