FROM eclipse-temurin:17-jdk

ENV GLASSFISH_VERSION=7.0.21
ENV GLASSFISH_HOME=/opt/glassfish7

RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://download.eclipse.org/ee4j/glassfish/glassfish-${GLASSFISH_VERSION}.zip && \
    unzip glassfish-${GLASSFISH_VERSION}.zip -d /opt && \
    rm glassfish-${GLASSFISH_VERSION}.zip

# Copiar el WAR
COPY dist/Nurse.war ${GLASSFISH_HOME}/glassfish/domains/domain1/autodeploy/ROOT.war

# Railway usa este puerto
EXPOSE 8080

# Iniciar GlassFish en primer plano
CMD ["/opt/glassfish7/bin/asadmin", "start-domain", "--verbose"]