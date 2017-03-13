package server;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

class JabberServer extends Thread {
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  static Map players = new HashMap<String, Integer>();
  static int i = 0;
  public JabberServer(Socket s) 
      throws IOException {
    socket = s;
    in = 
      new BufferedReader(
        new InputStreamReader(
          socket.getInputStream()));
    out = 
      new PrintWriter(
        new BufferedWriter(
          new OutputStreamWriter(
            socket.getOutputStream())), true);
    start();
  }
  public void run() {
    try {
      while (true) {         
        String str = in.readLine();
        i += 1;
        if (str.equals("END")) break;
        System.out.println("Echoing: " + str);
        players.put(str, i);
        out.println(str + " connected");
        System.out.println(i);
        out.println(i);
      }
      System.out.println("closing...");
    } catch(IOException e) {
      System.err.println("IO Exception");
    } finally {
      try {
        socket.close();
      } catch(IOException e) {
        System.err.println("Socket not closed");
      }
    }
  }
}

public class MultiJabberServer {  
  static final int PORT = 8080;
  public static void main(String[] args)
      throws IOException {
    ServerSocket s = new ServerSocket(PORT);
    System.out.println("Server Started");
    try {
      while(true) {
        Socket socket = s.accept();
        try {
          new JabberServer(socket);
        } catch(IOException e) {
          socket.close();
        }
      }
    } finally {
      s.close();
    }
  } 
}