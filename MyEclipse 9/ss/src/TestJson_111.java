

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;

class PersonInfo2{
	PersonInfo2(String name,int age){
		this.name = name;
		this.age = age;
	}
	public PersonInfo2() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private String name;
	private int age;
}

class FriendsBook2{
	FriendsBook2(String ownerName,String friendsBook){
		this.ownerName = ownerName;
		this.friendsBook2 = friendsBook;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getFriendsBook() {
		return friendsBook2;
	}
	public void setFriendsBook(String friendsBook) {
		this.friendsBook2 = friendsBook;
	}
	private String ownerName;
	private String friendsBook2;
}


//define a PersonBean to test Bean to Json
class PersonBean2{
	PersonBean2(int id,String name,int age){
		setId(id);
		setName(name);
		setAge(age);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int id;
	private String name;
	private int age;
	private ArrayList<String>friendsList;
}

/**
 * 
 * Java Object TO JSON String
 *
 */

public class TestJson_111 {
	//use Gson lib
    private static Gson gson = new Gson();
    
    public String GetStringToJson(){
        String jsonResult = gson.toJson(new String("aaa"));
        return jsonResult;
    }
    
    public String GetArrayListToJson(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");       
        list.add("ccc");       
        String jsonResult = gson.toJson(list);
        return jsonResult;
    }
    
    public String GetHashMapToJson(){
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "aaa"); 
        map.put(2, "bbb"); 
        map.put(3, "ccc"); 
        String jsonResult = gson.toJson(map);
        return jsonResult;
    }
    
    public String GetPersonBeanToJson(){
    	PersonBean pbean = new PersonBean(0,"aaa",21);
    	String jsonResult = gson.toJson(pbean);
    	return jsonResult;
    }
    
    public String GetFriendsBookToJson(){
    	PersonInfo p0 = new PersonInfo("John",22);
    	PersonInfo p1 = new PersonInfo("Marry",24);
    	PersonInfo p2 = new PersonInfo("Hellon",21);
    	List<PersonInfo> friendsList = new ArrayList<PersonInfo>();
    	friendsList.add(p0);
    	friendsList.add(p1);
    	friendsList.add(p2);
    	FriendsBook friendsBook = new FriendsBook("OWNER",friendsList);
    	String jsonResult = gson.toJson(friendsBook);
    	return jsonResult;
    }
    
}
