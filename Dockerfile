FROM openjdk:23-slim as base

# Installation de Maven
ARG MAVEN_VERSION=3.9.6
ARG USER_HOME_DIR="/src"
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries
RUN apt-get update && apt-get install -y curl
RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
# https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz
 && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
 && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
 && rm -f /tmp/apache-maven.tar.gz \
 && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/default-jvm/
# Define default command.

CMD ["mvn", "--version"]

WORKDIR /oc-p11/backend/

CMD ./mvn package

WORKDIR /OC-P11/backend/target/

ARG JAR_FILE
COPY ${JAR_FILE} ./target/backend-0.0.2.jar
ENTRYPOINT ["java","-jar","./target/backend-0.0.2.jar"]
