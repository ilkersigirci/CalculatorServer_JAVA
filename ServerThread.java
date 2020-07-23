import java.io.*;
import java.net.*;

public class ServerThread extends Thread {

    private Socket socket = null;
    private String message = null;
    private InputStream input = null;
    private OutputStream output = null;

    public ServerThread(Socket socket, String message) {
        this.socket = socket;
        this.message = message;
    }

    @Override
    public void run() {

        try {
            input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String text;

            while (true) {
                try {
                    text = reader.readLine();
                    if (text.equals("exit")) {
                        socket.close();
                        break;
                    }
                    try {
                        Calculator calc = new Calculator(text);
                        int calculatedResult = calc.calculate();
                        writer.println(message + " " + calculatedResult);
                    } catch (Exception e) {
                        writer.println("ERROR");
                        continue;
                    }
                    
                    //String reverseText = new StringBuilder(text).reverse().toString();

                } catch (IOException e) {
                    break;
                }
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
                //socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}