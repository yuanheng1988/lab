import com.google.gson.Gson;

public class TestJson {
	/*private static final TestJson_1 tj1 = new TestJson_1();
	private static final TestJson_2 tj2 = new TestJson_2();*/
	public static void main(String[] args){
		//Java Object to JSON String
		/*System.out.println("TestStringToJson: " 
				+ tj1.GetStringToJson() + "\n");
		System.out.println("TestArrayListToJson: " 
				+ tj1.GetArrayListToJson() + "\n");
		System.out.println("TestHashMapToJson: " 
				+ tj1.GetHashMapToJson() + "\n");
		System.out.println("TestPersonBeanToJson: " 
				+ tj1.GetPersonBeanToJson() + "\n");
		System.out.println("TestFriendsBookToJson: \n" 
				+ tj1.GetFriendsBookToJson() + "\n");*/
		
		/*
		 * reverse JSON String To Java Object
		 */
		System.out.println("/***********************JSON String To Java Object******************************************/\n");
		
		/*String jsonToString = tj1.GetStringToJson();
		System.out.println("Json To String: " 
				+ tj2.GetJsonToString(jsonToString) + "\n");
		
		String jsonToArrayList_String_ = tj1.GetArrayListToJson();
		System.out.println("Json To ArrayList----list[0]: " 
				+ tj2.GetJsonToArrayList(jsonToArrayList_String_).get(0) + "\n");
		
		String jsonToHashMap = tj1.GetHashMapToJson();
		System.out.println("Json To HashMap----hashMap.get(3): " 
				+ tj2.GetJsonToHashMap(jsonToHashMap).get(3) + "\n");
		
		String jsonToPersonBean = tj1.GetPersonBeanToJson();
		System.out.println("Json To PersonBean----personBean.getName(): " 
				+ tj2.GetJsonToPersonBean(jsonToPersonBean).getName() + "\n");*/
		
//		String jsonToFriendsBook = tj1.GetFriendsBookToJson();
//		FriendsBook fb = tj2.GetJsonToFriendsBook(jsonToFriendsBook);
		String ss = "{'ownerName':'\"OWNE::::R\"','friendsBook':[{'name':'John','age':22},{'name':'katty','age':13},{'name':'bob','age':23}]}";
		Gson gson = new Gson();
		FriendsBook friendsBook = gson.fromJson(ss, FriendsBook.class);
		System.out.println("Json To FriendsBook----friendsBook.getFriendsBook().get(0).getName(): " 
				+ friendsBook.getOwnerName() + "\n");
	}
}
