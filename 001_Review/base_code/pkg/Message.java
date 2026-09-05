package pkg;
import java.util.*;
import java.io.*;

public class Message {
	private String auth;
	private String subj;
	private String bod;
	private int i;
	private ArrayList<Message> childList;
	// Default Constructor
	public Message() {
		auth = "";
		subj = "";
		bod = "";
		i = 0;
		childList = new ArrayList<Message>();
	}
	
	// Parameterized Constructor
	public Message(String auth, String subj, String bod, int i) {
		this.auth  = auth;
		this.subj = subj;
		this.bod = bod;
		this.i = i;
		this.childList = new ArrayList<Message>();
	}

	// This function is responsbile for printing the Message
	// (whether Topic or Reply), and all of the Message's "subtree" recursively:

	// After printing the Message with indentation n and appropriate format (see output details),
	// it will invoke itself recursively on all of the Replies inside its childList, 
	// incrementing the indentation value at each new level.

	// Note: Each indentation increment represents 2 spaces. e.g. if indentation ==  1, the reply should be indented 2 spaces, 
	// if it's 2, indent by 4 spaces, etc. 
	public void print(int indentation){
		if(childList.size()-indentation == 0){
			return;
		}
		if(childList.get(indentation).isReply() == false){
			System.out.println("Message #" + childList.get(indentation).getId() + ": \"" + childList.get(indentation).getSubject() + "\"");
		}
		for (int j = 0; j < indentation*2; j++) {
			System.out.print("  ");
		}
		System.out.println("From " + auth + ": \"" + bod + "\"");
		print(indentation++);
	}

	// Default function for inheritance
	public boolean isReply(){
		return false;
	}

	// Returns the subject String
	public String getSubject(){
		return subj;
	} 

	// Returns the ID
	public int getId(){
		return i;
	}

	// Adds a child pointer to the parent's childList.
	public void addChild(Message child){
		childList.add(child);
	}

}
