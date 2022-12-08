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


 #Report exemple After running test #

* Inside this folder LeCollectionistTest/target/surefire-reports/emailable-report.html, you can find the report bellow

![rep4](https://user-images.githubusercontent.com/116507752/206049067-fba0f10b-6508-4d80-8ba2-df77af4631a0.PNG)

* Inside this folder LeCollectionistTest/target/surefire-reports/Suite/Research%20And%20Information%20Test.html, you can find the report bellow

![rep3](https://user-images.githubusercontent.com/116507752/206049163-c3264906-c6a3-4f46-a885-46c0f6dd8cee.PNG)

 #Allure report #
 * To find allure report documentation : 
 https://docs.qameta.io/allure/
 
 * Report exapmle : 
 ![Capture1](https://user-images.githubusercontent.com/116507752/206323116-8a34e05e-5322-491b-95d9-41cc4575ec65.PNG)
 
 
 #Jenkins integration #

* To run the project, you need to choose the paramters like the photo below

![lecollectionniste2](https://user-images.githubusercontent.com/116507752/205698082-b991a7c6-6b06-41d6-b924-2b158a1b02af.PNG)

* You will find the project report

![rep2](https://user-images.githubusercontent.com/116507752/206048397-4fc86747-f80d-430d-955a-0d94ad9dd961.PNG)


