import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

/*
 * For the ADMIN only
 * 
 * A table displaying all users, with all of their details
 * 
 * ADMIN can edit/delete user
 */
public class UserTableModel extends AbstractTableModel{
	
	//Admin as default user
	private User[] presetUser = new User[] 
	{
			/*
			 * We do not need this anymore since data is already saved through JSON
			 * 
			new User("Admin", 0)
			*/
	};
	
	//Creating arrayList to store the users
	private ArrayList<User> usersList = new ArrayList<>();
	
	//Add default to array
	UserTableModel()
	{
		usersList.addAll(Arrays.asList(presetUser));
	}
	
	/*
	 * Get the user clicked on the table model ==> So that we can edit them, or delete them
	 */
	public User getUser(int rowIndex) {
		return usersList.get(rowIndex);
	}
	
	
	/*
	 * Insert monarch into the Scroll Pane
	 */
	public void addUser(User newUser) {
		//Adding new user into the table
		usersList.add(newUser);
		
		//updates table
		fireTableDataChanged();
	}

	/*
	 * Column Headings (Name, UserID, Password
	 */
	public String getColumnName(int columnIndex) 
	{
		if(columnIndex == 0) 
		{
			return "Name";
		}
		else if(columnIndex == 1)
		{
			return "UserID";
		}
		else
		{
			return null;
		}
	}
	
	
	public int getRowCount() {
		// Amount of users
		return usersList.size();
	}


	public int getColumnCount() {
		// 2 columns: Name + UserID
		return 2;
	}


	public Object getValueAt(int rowIndex, int columnIndex) {
		User user = usersList.get(rowIndex);
		/*
		 * DISPLAYING INPUT ON TABLE
		 * 
		 * 
		 * Error fixed. Now need to fix error in addUser() in AdminCreateUser and  work on reading input from AdminCreateUser and displaying it on TableModel
		 */
		if(columnIndex == 0) 
		{
			return user.getName();
		}
		else if(columnIndex == 1)
		{
			return user.getUserID();
		}
		else
		{
			return null;
		}
	}
	
	
	
	//Default path to save the data — home directory
	private Path getDefaultPath() {
		String home = System.getProperty("user.home");
		return Paths.get(home).resolve("teachers.json");
	}
	
	
	
	//Saving as Json Data without path provided - in user's home directory
	public void save() {
		save(getDefaultPath());
	}
	
	
	
	//Saving as Json Data with path provided
	public void save(Path path) {
		//Converting all of the Users in the table model into JSON Objects
		JsonArray ja = new JsonArray();
		
		//For each user in the list of users, we will add them into the json array
		for(User user : usersList) {
			ja.add(user.toJsonObject());
		}
		
		//Convert Json array to json text
		String jsontext = Jsoner.serialize(ja);
		
		//Writing that json text to the file path
		try {
			Files.write(path, jsontext.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	//Load method from the default path
	public void load() {
		load(getDefaultPath());
	}
	
	
	
	//Method to load back the data when we run the program
	public void load(Path path) {
		
		//Declaring json variables
		String jsonText = null;
		JsonArray ja = null;
		
		//Read in the text from the file
		try {
			jsonText = new String(Files.readAllBytes(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
		
		//Convert the text into Json Objects
		try {
			ja = (JsonArray)Jsoner.deserialize(jsonText);
		} catch (JsonException e) {
			throw new RuntimeException(e);
		}
		
		for(Object object : ja) {
			//Each object here is the teacher that we saved from the User class
			
			//Convert the object into json object first
			JsonObject jo = (JsonObject)object;
			
			//Create user from the json object
			User user = User.fromJsonObject(jo);
			
			//add that user to the list of users
			usersList.add(user);
		}
	}
}
