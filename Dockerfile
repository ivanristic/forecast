FROM maven:latest as mavenbuild
WORKDIR /usr/src/forecast/
COPY . .
RUN mvn -B -s /usr/share/maven/ref/settings-docker.xml package -DskipTests

FROM websphere-liberty:latest AS production
WORKDIR /opt/ibm/wlp/usr/servers/defaultServer/dropins/
ADD deploy/wsl/jvm.options /opt/ibm/wlp/usr/servers/defaultServer/jvm.options
COPY --from=mavenbuild /usr/src/forecast/target/forecasts-0.0.1-SNAPSHOT.war app.war
RUN chmod 755 -c app.war