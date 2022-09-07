package utilities;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfig {

    public Map<String ,String > defaultHeader(){
        Map<String , String > contentType=new HashMap<>();
        contentType.put("Content-Type","application/json");
        return contentType;
    }
    public Map<String ,String > defaultHeaderWithAccessToken(){
        Map<String , String > contentType=new HashMap<>();
        contentType.put("Content-Type","application/json");
        return contentType;
    }
}
