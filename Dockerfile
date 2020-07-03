FROM alpine
RUN apk update
RUN apk upgrade
RUN apk add openjdk8
ADD target/aggregator-0.0.1-SNAPSHOT.jar /
# 405 is uid of guest user in alpine
USER 405
ENV PORT=8070
EXPOSE 8070
ENTRYPOINT ["java","-jar","aggregator-0.0.1-SNAPSHOT.jar"]