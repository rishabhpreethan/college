import java.net.*;
import java.io.*;


public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 4001);
        // Reading file name from keyboard (input stream)
        System.out.println("Enter file name : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file_name = br.readLine();
        // Sending file name to server (print writer)
        OutputStream out = s.getOutputStream();
        PrintWriter pw = new PrintWriter(out, true);
        pw.println(file_name);
        // Receiving content from server (input stream)
        InputStream inp = s.getInputStream();
        BufferedReader contentRead = new BufferedReader(new InputStreamReader(inp));
        String str;
        while ((str = contentRead.readLine()) != null) System.out.println(str);
        pw.close();
        contentRead.close();
        br.close();
    }
}


// add vit.txt file in same location and when asked for file name : vit.txt (will read contents of file)