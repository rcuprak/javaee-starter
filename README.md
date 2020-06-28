# javaee-starter
This is a JakartaEE 8 "starter project" to help you start developing your own Jakarta EE 8 application.

This starter application has the following features:
 * Maven based 
 * Java 11
 * Sample JSF page
 * Arquillian integration tests (using embedded [Payara](https://www.payara.fish "Payara") container)
 
 Since this is a Maven based project, you can easily open it using IntelliJ, Eclipse, or NetBeans.
 
 ## Setup
 
This project uses [Maven toolchain](https://maven.apache.org/guides/mini/guide-using-toolchains.html "Maven Toolchain"). 

In ~/.m2/toolchain.xml make sure you have an Oracle Java 11 JVM defined that matches the configuration in the pom.xml.

## Building & Running

To build this project:
* mvn package (this will run the integration tests and your code will execute in a container)
* cd target/
* If you are using Payara:
  * asadmin start-domain domain1 (default server non-production server configuration)
  * asadmin deploy starter-1.1.war (then goto https://localhost:8080/)
  * In your web browser: https://localhost:8080/starter



 
