package client_;
import java.net.*;
import java.io.*;
import java.util.*;

public class JabberClient {
  public static void main(String[] args) throws IOException {
    InetAddress addr = InetAddress.getByName(null);
//    System.out.println("addr = " + addr);
    Socket socket = new Socket(addr, 8080); 
     boolean cont = true;
     Scanner input = new Scanner(System.in);
    
    try {
//      System.out.println("socket = " + socket);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
     
      PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
      while (cont) {
        System.out.println("Type your name>>");
        String name = input.nextLine();
        out.println(name);
        String str = in.readLine();
        System.out.println(str);
        int i = in.read();
        System.out.println(i);
        Player p = new Player(name, i);
        System.out.println(p.name);
        System.out.println(p.type);
        if (i == 1) System.out.println("You are X player");
        else System.out.println("You are O player");
        if (str.equals("close") )
           cont=false;
      }
      
    } finally {
      System.out.println("closing...");
      socket.close();
    }
  }
} 
