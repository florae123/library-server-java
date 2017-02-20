#Library server
A java server for a Library app.

Requires a Cloudant NoSQL Database.

##Deploy to Bluemix

1. Clone the app to your local environment from your terminal using the following command

  ```
  git clone https://github.com/florae123/library-server-java.git
  ```
2. Execute full Maven build to create the target/name.war file:

  ```
  $ mvn clean install
  ``` 
  
2. Log in to your Bluemix account using the Cloud Foundry CLI tool. Provide your username and password when prompted.
  ```
  cf login
  ```

3. Push the app to Bluemix using the cf cli command
  ```
  cf push MyName -p target/name.war
  ```
4. Instantiate a Cloudant NoSQL Database on Bluemix and connect it to your app. 
  