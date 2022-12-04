# Description :

This projet allow to test the leCollectionnist platform web 

# link : https://www.lecollectionist.com/

### Configuration and prerequisites ###

 # Java #
In this project we use PageFactory to implement Page Object Model concept. It's recommended to use JAVA 11 (for this project I used java version "11.0.15")

 
 # Maven #
To install Maven follow this : https://phoenixnap.com/kb/install-maven-windows
 
Important :

Don't forget to check if JAVA and MAVEN are well installed by doing
 - java -version
 - mvn -v

The version used during development are :

 - Java : java version "11.0.15"
 - Mvn : Apache Maven 3.8.2

#How to use project

#Step1

clone the repostery from :

	git clone https://github.com/Jebali02/LeCollectionistTest
	
#Step2

Go inside the project in the workspace where you have cloned the project and write this commands :
   
    - mvn clean 
  	- mvn test -Dbrowser="browser" -Denv="env"
 
 Available browser : 
 - chrome
 - firefox
 - edge
 
 Available env :
 - qa
 - dev
 - preprod
 - prod 
 
Example :  mvn test -Dbrowser="chrome" -Denv="qa"
Means that the test will be run on chrome on qa environment.


###Report exemple After running test ###

