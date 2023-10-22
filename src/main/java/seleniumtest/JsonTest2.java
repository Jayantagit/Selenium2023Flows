package seleniumtest;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import io.restassured.path.json.JsonPath;

public class JsonTest2 {

	public static void main(String[] args) throws IOException {

		System.out.println("==========================");
		String resBody = "{\r\n" + "    \"store\": {\r\n" + "        \"book\": [\r\n" + "            {\r\n"
				+ "                \"category\": \"reference\",\r\n" + "                \"author\": \"Nigel Rees\",\r\n"
				+ "                \"title\": \"Sayings of the Century\",\r\n" + "                \"price\": 8.95\r\n"
				+ "            },\r\n" + "            {\r\n" + "                \"category\": \"fiction\",\r\n"
				+ "                \"author\": \"Evelyn Waugh\",\r\n"
				+ "                \"title\": \"Sword of Honour\",\r\n" + "                \"price\": 12.99\r\n"
				+ "            },\r\n" + "            {\r\n" + "                \"category\": \"fiction\",\r\n"
				+ "                \"author\": \"Herman Melville\",\r\n"
				+ "                \"title\": \"Moby Dick\",\r\n" + "                \"isbn\": \"0-553-21311-3\",\r\n"
				+ "                \"price\": 8.99\r\n" + "            },\r\n" + "            {\r\n"
				+ "                \"category\": \"fiction\",\r\n"
				+ "                \"author\": \"J. R. R. Tolkien\",\r\n"
				+ "                \"title\": \"The Lord of the Rings\",\r\n"
				+ "                \"isbn\": \"0-395-19395-8\",\r\n" + "                \"price\": 22.99\r\n"
				+ "            }\r\n" + "        ],\r\n" + "        \"bicycle\": {\r\n"
				+ "            \"color\": \"red\",\r\n" + "            \"price\": 19.95\r\n" + "        }\r\n"
				+ "    },\r\n" + "    \"expensive\": 10\r\n" + "}";
		JsonPath js = new JsonPath(resBody);
		List<Object> authorList = js.getList("store.book.title");
		Set<String>authList=new  LinkedHashSet<String>();
		for(Object o:authorList)
		{
			authList.add(o.toString());
		}
		System.out.println(authList);

	}

}
