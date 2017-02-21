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
  mvn clean install
  ```

2. Log in to your Bluemix account using the Cloud Foundry CLI tool. Provide your username and password when prompted.
  ```
  cf login
  ```

3. Push the app to Bluemix using the cf cli command
  ```
  cf push MyName -p target/name.war
  ```
4. Create an instance of the Cloudant NoSQL DB Service on Bluemix and connect it to your app.

##Configure Databases

The App requires three databases in your Cloudant service.

1. Create a database called **"books"**. A book should be saved as a JSON in the following format:
	{
	  "_id": "...",
	  "_rev": "...",
	  "id": "id must be the same as _id",
	  "isbn": "the book's isbn",
	  "authors": [
	    "the book's author"
	  ],
	  "title": "bookTitle",
	  "tags": [
	    "Keywords", "that match", "the book"
	  ],
	  "picture": "the book's cover",
	  "about_the_book": "a description to be read by Text to Speech"
	}


2. Create a database called **"customers"**. A customer should be saved as a JSON in the following format:
	{
	  "_id": "the customer's id"
	  "name": "the customer's name",
	  "email": "the customer's email address",
	  "password": "the customer's password",
	  "id": "must be the same as _id"
	}

3. Create a database called **"rentals"**. Whenever a book is borrowed, it is registered in "rentals". A rental should be saved as a JSON in the following format:
  {
    "_id": "the rental's id",
    "_rev": "...",
    "id": "must be the same as _id",
    "bookid": "the id of the book borrowed",
    "customerid": "the id of the customer borrowing the book",
    "start": "Mar 3, 2017 12:00:00 AM",
    "end": "May 4, 2017 12:00:00 AM"
  }
