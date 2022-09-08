package utilities;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfig {
    private HeaderConfig(){}
    public static Map<String ,String > defaultHeader(){
        Map<String , String > contentType=new HashMap<>();
        contentType.put("Content-Type","application/json");
        return contentType;
    }
    public static Map<String ,String > defaultHeaderWithAccessToken(){
        Map<String , String > contentType=new HashMap<>();
        contentType.put("Content-Type","application/json");
        return contentType;
    }
}
