FROM azul/zulu-openjdk:21 AS build

# Install Node.js
ENV NODE_VERSION=22.12.0
RUN apt-get update && apt-get install -y curl
RUN curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.1/install.sh | bash
ENV NVM_DIR=/root/.nvm
RUN . "$NVM_DIR/nvm.sh" && nvm install ${NODE_VERSION}
RUN . "$NVM_DIR/nvm.sh" && nvm use v${NODE_VERSION}
RUN . "$NVM_DIR/nvm.sh" && nvm alias default v${NODE_VERSION}
ENV PATH="/root/.nvm/versions/node/v${NODE_VERSION}/bin/:${PATH}"
RUN node --version
RUN npm --version

WORKDIR /root/build/

# Copy Gradle wrapper and config
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle .
COPY settings.gradle .
COPY gradle.properties .

# Make gradlew executable
RUN chmod +x gradlew

# NPM Restore
COPY client/package*.json client/
RUN cd client && npm ci

# Copy full source
COPY . .

# Build and Bundle
RUN ./gradlew bundle

# --- Runtime Stage ---
FROM azul/zulu-openjdk-alpine:21-jre

WORKDIR /root/app/

COPY --from=build /root/build/.deploy ./

EXPOSE 8080

# Spring Boot already runs on 8080 by default in application.yml

CMD ["java", "-jar", "server.jar"]
