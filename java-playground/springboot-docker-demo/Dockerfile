FROM openjdk:11
RUN addgroup --system springgroup
RUN adduser --system springuser
RUN adduser springuser springgroup
USER springuser:springgroup

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.springbootdockerdemo.SpringbootDockerDemoApplication"]
