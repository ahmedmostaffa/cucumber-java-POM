package utilities;


import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonReader {
	private JsonReader() {}


	public static String getValue(String filePath,String key)  {
		JSONObject jsonObject=getJsonObject(filePath);
		String value=jsonObject.get(key).toString();
		return value;
	}

	public static JSONArray getJsonArray(String filePath){
		try {
			JSONObject jsonObject=getJsonObject(filePath);
			Object obj=(Object) jsonObject;
			JSONArray jsonArray=(JSONArray) obj;
			return jsonArray;
		}catch (Exception e) {
			e.fillInStackTrace();
		}
		return null;
	}

	public static JSONObject getJsonObject(String filePath,String key) {
		try {
			JSONObject jsonObject=getJsonObject(filePath);
			return (JSONObject) jsonObject.get(key);
		}catch (Exception e) {
			e.fillInStackTrace();
		}
		return null;
	}
	public static JSONArray getJsonArray(String filePath, String key) {
		try {
			JSONObject jsonObject=getJsonObject(filePath);
			JSONArray jsonArray=(JSONArray) jsonObject.get(key);
			return jsonArray;
		}catch (Exception e) {
			e.fillInStackTrace();
		}
		return null;
	}
	public static JSONObject getJsonObject(String filePath){
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader(filePath);
			Object obj=jsonParser.parse(reader);
			JSONObject jsonObject=(JSONObject) obj;
			return jsonObject;
		}catch (Exception e) {
			e.fillInStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		//System.out.println(getJsonArray(".//resources//TestData//MOCK_DATA.json").toArray()[0]);
		String value=JsonReader.getValue(".//resources//TestData//Headers.json","GET_LIST_OF_USERS").toString();
		System.out.println(value);
	}
	

}
