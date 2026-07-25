FROM eclipse-temurin:17-jdk

ENV GLASSFISH_VERSION=7.0.21
ENV GLASSFISH_HOME=/opt/glassfish7

RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://download.eclipse.org/ee4j/glassfish/glassfish-${GLASSFISH_VERSION}.zip && \
    unzip glassfish-${GLASSFISH_VERSION}.zip -d /opt && \
    rm glassfish-${GLASSFISH_VERSION}.zip

# Copiar como ROOT.war dentro de la carpeta autodeploy
COPY dist/Nurse.war ${GLASSFISH_HOME}/glassfish/domains/domain1/autodeploy/ROOT.war

EXPOSE 8080
