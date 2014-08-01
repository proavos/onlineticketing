Online Ticketing
----------------

Steps for setting up the project are described below;

1. Download and install the latest Wildfly application server from http://wildfly.org/downloads/

2. Download and install the community edition of  IntelliJ IDEA integrated development environment from http://www.jetbrains.com/idea/download/

3. Clone the project from https://github.com/proavos/onlineticketing

git clone https://github.com/proavos/onlineticketing

4. Import the project into IntelliJ Idea as a Maven project

5. Setup MySQL datasource in Wildfly server as follows
	a. Define module under <WILDFLY_HOME>/modules/system/layers/base/com/mysql for mysql with the driver library included
	b. Add datasource definition to <WILDFLY_HOME>/standalone/configuration/standalone.xml

6. Start the Wildfly server in standalone mode

sh <WILDFLY_HOME>/bin/standalone.sh

7. Build and deploy the project

cd <WORKSPACE>/onlineticketing
mvn clean package wildfly:deploy

Note: You may integrate the Wildfly server into IntelliJ Idea and start the server from with in the IDE



