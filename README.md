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

Inside this folder LeCollectionistTest/target/surefire-reports/emailable-report.html, you can find the report bellow

![rap2](https://user-images.githubusercontent.com/116507752/205501638-9deb97a3-41cf-4a8f-b596-3a1a3ea0d952.PNG)

Inside this folder LeCollectionistTest/target/surefire-reports/Suite/Research%20And%20Information%20Test.html, you can find the report bellow

![reap1](https://user-images.githubusercontent.com/116507752/205501646-b90daa80-be65-46c3-83b1-4fc0ccb41d68.PNG)

