package seleniumtest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

public class JsonTest3 {

	public static void main(String[] args) throws IOException {

	List<String> authorList= JsonPath.parse(new File("./src/test/resources/JsonFiles/Sample.json"))
				.read("$.store.book[?(@.price>7.00)].author");
		System.out.println(authorList);
		
		System.out.println("================");
		
		List<Map<String,String>> bookList= JsonPath.parse(new File("./src/test/resources/JsonFiles/Sample.json"))
				.read("$.store.book[?(@.price>7.00)].['author','title']");
		System.out.println(bookList);

	}

}
