import java.net.*;
import java.io.*;

public class Client {

    private String serverName = "localhost";
    readConfigFile confFile = new readConfigFile("./config.properties");
    private int serverPort = confFile.getPort();
    
    private Socket socket = null;
    private InputStream input = null;
    private OutputStream output = null;

    public Client() {
        
        try {
            socket = new Socket(serverName, serverPort);
            System.out.println("Client started on port " + socket.getLocalPort()+"...");
            System.out.println("Connected to server " + socket.getRemoteSocketAddress());

            input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String text;    
            Console console = System.console();
            
            while (true) {
                try {
                    text = console.readLine("Enter text: ");
                    if(text.equals("exit")){ break; }

                    writer.println(text);
                    String reversedText = reader.readLine();
                    System.out.println(reversedText);
                    
                    
                } catch (IOException e) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]) {
        Client client = new Client();
    }
}