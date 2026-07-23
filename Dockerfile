FROM eclipse-temurin:17-jdk

ENV GLASSFISH_VERSION=7.0.21
ENV GLASSFISH_HOME=/opt/glassfish7

RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://download.eclipse.org/ee4j/glassfish/glassfish-${GLASSFISH_VERSION}.zip && \
    unzip glassfish-${GLASSFISH_VERSION}.zip -d /opt && \
    rm glassfish-${GLASSFISH_VERSION}.zip

# Copiamos el WAR a la raíz de opt
COPY dist/Nurse.war /opt/Nurse.war

EXPOSE 8080

# Iniciamos el dominio, desplegamos forzando contextroot=/ y mantenemos los logs activos
CMD ["sh", "-c", "${GLASSFISH_HOME}/bin/asadmin start-domain && ${GLASSFISH_HOME}/bin/asadmin deploy --contextroot / --name ROOT /opt/Nurse.war && tail -f ${GLASSFISH_HOME}/glassfish/domains/domain1/logs/server.log"]
