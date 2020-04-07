How to run SonarQube in local slice or developer machine ?

Get Started in Two Minutes Guide
Download the SonarQube Community Edition

Unzip it, let's say in C:\sonarqube or /etc/sonarqube

Start the SonarQube Server:

```
# On Windows, execute:
C:\sonarqube\bin\windows-x86-xx\StartSonar.bat
```

```
# On other operating systems, execute:
/etc/sonarqube/bin/[OS]/sonar.sh console
```

Log in to http://localhost:9000 with System Administrator credentials (admin/admin)

===============================================================================================

For multi-language projects, remove the property "sonar.language=java" from "sonar-project.properties"
