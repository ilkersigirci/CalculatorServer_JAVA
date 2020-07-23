import java.io.*;
import java.net.*;
import java.util.*;

public class readConfigFile {

    private int port;
    private String message;
    
    public readConfigFile(String filePath) {
        Properties prop = new Properties();
        try (InputStream fis = new FileInputStream(filePath)) {
            prop.load(fis);

            port = Integer.parseInt(prop.getProperty("PORT"));
            message = prop.getProperty("BIND_MESSAGE");

        } catch (Exception e) {
            System.out.println("Unable to find the specified properties file");
            e.printStackTrace();
        }
    }

    public int getPort() {
        return port;
    }

    public String getMessage() {
        return message;
    }

}