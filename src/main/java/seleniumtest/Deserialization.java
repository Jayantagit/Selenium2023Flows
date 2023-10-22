package seleniumtest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserialization {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		List<Map<String,Object>>bookList=mapper.readValue(new File("./src/test/resources/JsonFiles/SampleS.json"),
				new TypeReference<List<Map<String,Object>>>(){});
		System.out.println(bookList);
		

	}

}
