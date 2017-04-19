/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maria
 */
public class MultiJabberServer {

    public static List<JabberServer> js;
    static final int PORT = 8080;
    
    public static void main(String[] args) throws IOException {
    ServerSocket s = new ServerSocket(PORT);
    System.out.println("Server Started" + s);
    try {
      js = new ArrayList();
      while(true) {
        Socket socket = s.accept();
        System.out.println("Connection accepted: " + socket);
        js.add(new JabberServer(socket));
      }
    } finally {
      s.close();
    }
  } 
    }
    

