import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

//JSON String To Java Object
public class TestJson_2 {
	private static Gson gson = new Gson();
	public String GetJsonToString(String jsonString){
		String str = gson.fromJson(jsonString, String.class);
		return str;
	}
	
	public ArrayList<String> GetJsonToArrayList(String jsonString){
		ArrayList<String> list = 
			gson.fromJson(jsonString, new TypeToken<ArrayList<String>>(){}.getType());
		return list;
	}
	
	public Map<Integer, String> GetJsonToHashMap(String jsonString){
		HashMap<Integer,String> hashMap = 
			gson.fromJson(jsonString, new TypeToken<HashMap<Integer,String>>(){}.getType());
		return hashMap;
	}
	
	public PersonBean GetJsonToPersonBean(String jsonString){
		PersonBean personBeanArrayList =
			gson.fromJson(jsonString, PersonBean.class);
		return personBeanArrayList;
	}
	
	public FriendsBook GetJsonToFriendsBook(String jsonString){
		FriendsBook friendsBook = gson.fromJson(jsonString, FriendsBook.class);
		return friendsBook;
	}
	
}
