package utilities;


import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonReader {
	private JsonReader() {}
	
	public static String getValue(String fileName,String key)  {
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader(".\\resources\\TestData\\"+fileName+".json");
			Object obj=jsonParser.parse(reader);
			JSONObject jsonObject=(JSONObject) obj;
			String value=jsonObject.get(key).toString();
			return value;
		}catch (IOException e ) {
			e.fillInStackTrace();	
		}catch( ParseException e){
			e.fillInStackTrace();
		}
		return null;
	}
	public static JSONObject getJsonObject(String fileName,String key) {
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader(".\\resources\\TestData\\"+fileName+".json");
			Object obj=jsonParser.parse(reader);
			JSONObject jsonObject=(JSONObject) obj;
			return (JSONObject) jsonObject.get(key);
		}catch (Exception e) {
			e.fillInStackTrace();
		}
		return null;
	}
	public static JSONArray getJsonArray(String fileName, String key) {
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader(".\\resources\\TestData\\"+fileName+".json");
			Object obj=jsonParser.parse(reader);
			JSONObject jsonObject=(JSONObject) obj;
			JSONArray jsonArray=(JSONArray) jsonObject.get(key);
			return jsonArray;
		}catch (Exception e) {
			e.fillInStackTrace();
		}
		return null;
	}
	public static JSONObject getJsonObject(String fileName){
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader(".\\resources\\TestData\\"+fileName+".json");
			Object obj=jsonParser.parse(reader);
			JSONObject jsonObject=(JSONObject) obj;
			return jsonObject;
		}catch (Exception e) {
			e.fillInStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getValue("Headers","POST"));

	}
	

}
