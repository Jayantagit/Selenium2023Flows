package seleniumtest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

public class JsonTest {

	public static void main(String[] args) throws IOException {

		List<Map<String, Object>> listMap = JsonPath.read(new File("./src/test/resources/JsonFiles/Sample.json"),
				"$.store.book[?(@.category=='fiction')]");
		System.out.println(listMap);

		System.out.println("==========================");
		List<String> authorList = JsonPath.read(new File("./src/test/resources/JsonFiles/Sample.json"),
				"$.store.book[*].author");

		authorList.forEach(s -> System.out.println(s));

		

	}

}
