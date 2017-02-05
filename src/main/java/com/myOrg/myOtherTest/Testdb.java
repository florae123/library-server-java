package com.myOrg.myOtherTest;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
//import com.cloudant.client.org.lightcouch.CouchDbException;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.cloudant.*;
//import com.ibm.json.java.JSONObject;


public class Testdb {
	
	private static CloudantClient cloudant = null;
	private static Database db = null;
	
	private static String user = "81521cc0-3ee9-4938-a300-17d01c412388-bluemix";
	private static String password = "3eb24addf758dcc8bc5ad6e25991e93f5345d19a27a1703eb26ff35088e0fb02";
	
	/**public static void main(String[] args){
		
		Database datab = getDB("books");
		
		//Book testBook = new Book("3","3a","3a","3a");
		//new book to db
		//datab.save(testBook);
		
		Book indb = datab.find(Book.class, "4");
		System.out.println(indb.get_rev());
		//indb.setTitle(testBook.getTitle()); //and other updates with updatedBook.get...
		datab.update(indb);
		//update book
		//datab.update(updatedBook);
		
		//delete one book
		// check if document exist
		/**Book todelete = datab.find(Book.class, "3");
		datab.remove(todelete);
		System.out.println("Delete Successful.");*/
		
		//getBooks
		/**try {
			Collection<Book> allBooks = datab.getAllDocsRequestBuilder().includeDocs(true).build()
					.getResponse().getDocsAs(Book.class);
			for(Book temp : allBooks){
				System.out.println("Bookid: "+temp.getId()+" Title: "+temp.getTitle());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//getBook with id
		if(datab.contains("4")){
			Book found = datab.find(Book.class, "4");
			System.out.println("Bookid: "+found.getId()+" Title: "+found.getTitle());
		}

		//show list of all databases
		List<String> databases = cloudant.getAllDbs();
		System.out.println("All my databases : ");
		for ( String db : databases ) {
		    System.out.println(db);
		}

		//cloudant.deleteDB("example_db");
		
	}*/
	
	public static CloudantClient createClient(){
		try {
			System.out.println("Connecting to Cloudant : " + user);
			CloudantClient client = ClientBuilder.account(user)
					.username(user)
					.password(password)
					.build();
			return client;
		//} catch (CouchDbException e) {
		} catch (Exception e){
			throw new RuntimeException("Unable to connect to repository", e);
		}
	}
	
	public static void initClient() {
		if (cloudant == null) {
			cloudant = createClient();
			return;
		}else{
			return;
		}
	}
	
	public static Database getDB(String databaseName) {
		if (cloudant == null) {
			initClient();
		}

		try {
			db = cloudant.database(databaseName, false);
		} catch (Exception e) {
			throw new RuntimeException("DB Not found", e);
		}
		
		return db;
	}

}


