package data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		// Read Json to string 
		 String jsonContentString = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\data\\PurchaseOrder.json"),StandardCharsets.UTF_8);
		 
		 // String to HashMap (Jackson databind)
		 
		 ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String, String>> data = mapper.readValue(jsonContentString, new TypeReference<List<HashMap<String,String>>>() {
		});
		 return data;
		 // {map,map}
		 
	}
	
}
