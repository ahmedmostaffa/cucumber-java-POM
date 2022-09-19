package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;



public class ConfigReader {

    private static Properties prop = new Properties();
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static String FILE_PATH = "src/test/resources/config/config.properties";


    public static void main(String[] args) {
        // SOME TEST CASES
        System.out.println(getStringProperty("baseURL"));

    }

    public static Boolean getBooleanProperty(String key) {
        try {
            InputStream input = new FileInputStream(FILE_PATH);
            prop.load(input);
            Boolean value = Boolean.parseBoolean(prop.getProperty(key));
            return value;
        } catch (Exception exp){
            exp.printStackTrace();
        }
        return null;
    }

    public static String getStringProperty(String key) {
        try {
            InputStream input = new FileInputStream(FILE_PATH);
            prop.load(input);
            String value = prop.getProperty(key);
            return value;
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return null;
    }

    public static int getIntegerProperty(String key) {

        try {
            InputStream input = new FileInputStream(FILE_PATH);
            prop.load(input);
            int value = Integer.parseInt(prop.getProperty(key));
            return value;
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return -1;
    }

    public static void setProperty(String property, String value) {
        try {
            OutputStream output = new FileOutputStream(FILE_PATH);
            prop.setProperty(property, value);
            prop.store(output, null);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

}
