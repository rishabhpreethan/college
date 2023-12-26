import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4001);
        System.out.println("Server ready for connection");
        Socket s = ss.accept(); // binding with connection
        System.out.println("Connection success");
        // Reading file name from client
        InputStream inp = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inp));
        String file_name = br.readLine();
        // reading file content
        BufferedReader content = new BufferedReader(new FileReader(file_name));
        OutputStream out = s.getOutputStream();
        PrintWriter pw = new PrintWriter(out, true);
        String str;
        while ((str = content.readLine()) != null) {
            pw.println(str);
        }
        s.close();
        ss.close();
        pw.close();
        br.close();
        content.close();
    }
}