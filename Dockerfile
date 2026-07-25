FROM eclipse-temurin:17-jdk

ENV GLASSFISH_VERSION=7.0.21
ENV GLASSFISH_HOME=/opt/glassfish7

RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://download.eclipse.org/ee4j/glassfish/glassfish-${GLASSFISH_VERSION}.zip && \
    unzip glassfish-${GLASSFISH_VERSION}.zip -d /opt && \
    rm glassfish-${GLASSFISH_VERSION}.zip


# Copiar WAR al contenedor
COPY dist/Nurse.war /tmp/Nurse.war


EXPOSE 8080


CMD ["/bin/bash","-c","\
/opt/glassfish7/bin/asadmin start-domain && \
/opt/glassfish7/bin/asadmin deploy --force=true /tmp/Nurse.war && \
/opt/glassfish7/bin/asadmin set server-config.network-config.network-listeners.network-listener.http-listener-1.port=$PORT && \
tail -f /opt/glassfish7/glassfish/domains/domain1/logs/server.log \
"]