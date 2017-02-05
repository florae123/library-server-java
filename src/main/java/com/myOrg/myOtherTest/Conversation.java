package com.myOrg.myOtherTest;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.spi.Context;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.SearchResult;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;


@Path("/conversation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Conversation{
	
	
	private static ConversationService service = new ConversationService("2016-09-20");
	private static String workspaceIdCar = "33ffd4ea-46dc-44ca-9779-4ae8b30ee845";
	private static String workspaceId = "90ce6c55-d9b1-4688-bd7a-195d2b439bd6";
	
	public static void initConvService(){
		service.setUsernameAndPassword("3e1a82d7-cc32-4ddb-9ec9-fda20b7bd68a", "QvWCqU2Wxhym");
	}
	
	@GET
	public MessageResponse conversationStart(){
		initConvService();
		MessageRequest newMessage = new MessageRequest.Builder()
				  .inputText("")
				  .build();
		MessageResponse response = service
				  .message(workspaceId, newMessage)
				  .execute();
		return response;
	}
	
	@PUT
	//public MessageResponse getResponse(String userInput, MessageResponse lastResponse){
	public MessageResponse getResponse(Map<String,Object> userhelp){
		String userInput = (String) userhelp.get("user_input");
		
		initConvService();
		Map<String,Object> context = (Map<String,Object>) userhelp.get("context");
		MessageRequest newMessage = new MessageRequest.Builder()
				  .inputText(userInput)
				  .context(context)
				  .build();
		MessageResponse response = service
				  .message(workspaceId, newMessage)
				  .execute();
		//System.out.println("Response: "+response);
		//add appropriate books to response, if action select_books required
		Map<String, Object> output = response.getOutput();
		if(output.containsKey("action")){
			System.out.println(output.get("action")+" "+output.get("action_param"));
			if(output.get("action").equals("select_books")){
				List<Book> selectedBooks = BookResource.getRelevantBooks((String) output.get("action_param"));
				output.put("selected_books", selectedBooks);
			}
		}
		return response;
	}
	
	public static List<String> getOutputText(MessageResponse response){
		List<String> outputText = response.getText();
		return outputText;
	}
	
	
	public static void main(String[] args){
		initConvService();
		
		//List<Book> books = BookResource.getRelevantBooks("Fiction");
		//System.out.println("Amount of relevant books: "+books.size());
		MessageRequest init = new MessageRequest.Builder().build();
		MessageResponse responseinit = service.message(workspaceId, init).execute();
		Map<String,Object> initContext = responseinit.getContext();
		System.out.println("Responseinit: "+responseinit);
		
	
	
		//MessageResponse response = getResponse("I need a scifi book.", responseinit);
		//System.out.println(getOutputText(response));
		//System.out.println(response);
		
		
		
		
		
		/*MessageRequest othermessage = new MessageRequest.Builder()
				.inputText("Hello").build();
		
		MessageResponse otherresp = service
				.message(workspaceId, othermessage)
				.execute();
		//System.out.println(otherresp);
		System.out.println(getOutputText(otherresp));
		JSONObject json = new JSONObject(otherresp);
		//System.out.println(json.toString());
		JSONObject contextjson = json.getJSONObject("context");
		
		Map<String,Object> context = otherresp.getContext();
		
		//Context context = new Context(contextjson);
		
		MessageRequest newMessage2 = new MessageRequest.Builder()
				  .inputText("Turn on the lights")
				  // Replace with the context obtained from the initial request
				  .context(context)
				  .build();
		MessageResponse response2 = service
				  .message(workspaceId, newMessage2)
				  .execute();
			
				System.out.println("Response2: "+response2);*/
	}
	

	
}