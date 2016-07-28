# LangIdentify
Solution for Language Identifier code challenge

This application has been developed using Eclipse Luna as a maven build project.

To run you need to follow the following steps:
Note: make sure your have Eclipse maven plugin or maven installed on your system.
1. Go to src/com/langidentify/service/DictionaryHelper.java and change the path in  "Path dir = Paths.get("/Users/Anshu/Desktop/langfiles"); " on line number 34 to a valid path on your system where you have placed the language files.
2. Save the changes.
3. Go to the project folder on your system and run - mvn clean install
4. push the .war file in tomcat server webapp directory
5. Start tomcat.
6. After successful server start, open up a browser window and hit the URL http://localhost:8080/app
7. On Eclipse IDE having maven plugin, just right click on the project, and choose run as --> maven build ... --> goals: clean install and click run button
