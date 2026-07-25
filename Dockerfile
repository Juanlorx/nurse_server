FROM eclipse-temurin:17-jdk

ENV GLASSFISH_VERSION=7.0.21
ENV GLASSFISH_HOME=/opt/glassfish7

RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://download.eclipse.org/ee4j/glassfish/glassfish-${GLASSFISH_VERSION}.zip && \
    unzip glassfish-${GLASSFISH_VERSION}.zip -d /opt && \
    rm glassfish-${GLASSFISH_VERSION}.zip


# Copiar WAR dentro del contenedor
COPY dist/Nurse.war /tmp/Nurse.war


EXPOSE 8080


# Iniciar GlassFish y desplegar WAR
CMD ["/bin/bash", "-c", "\
/opt/glassfish7/bin/asadmin start-domain && \
/opt/glassfish7/bin/asadmin deploy --force=true /tmp/Nurse.war && \
tail -f /opt/glassfish7/glassfish/domains/domain1/logs/server.log \
"]