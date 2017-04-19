/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import static server2.MultiJabberServer.js;

/**
 *
 * @author Maria
 */
public class JabberServer extends Thread {
  private Socket socket;
  private BufferedReader in;
  PrintWriter out;
  public String name;
  public TicTacToe ttt;
  
  boolean client_connected = false;
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
 
  @Override
  public void run() {
    boolean run = true;
    while (run) {
            try {
                String string = in.readLine();
                if (string != null) {
                    if (string.equals("END"))
                        run = false;
                    else
                        parse(string);
                }
            } catch (IOException ex) {
                run = false;
                js.remove(this);
                try {
                    socket.close();
                } catch (IOException ex2) {}
                if (name!=null)
                    sendToAll("LEFT#"+name);
            }
        }
        }
  
 private void parse(String message) {
        System.out.println("Got message: " + message);
        String[] string = message.split("#");
        switch(string[0]) {
            case "JOIN":
                if (string.length < 2)
                    out.println("JOIN#ERROR#EMPTY_NAME");
                else if (findUser(string[1])!=null)
                    out.println("JOIN#ERROR#NAME_IN_USE");
                else {
                    name = string[1];
                    out.println("JOIN#SUCCESS");
                    sendToAll("JOINED#"+string[1]);
                    System.out.println(string[1]+" joined");
                }
                break;
                
            case "GAME":
                switch (string[1]) {
                    case "START":
                        if (js.size() >= 2) {
                            JabberServer oponent = js.get(1);
                            System.out.println(js);
                            ttt = new TicTacToe(js.get(0), oponent);
                            oponent.ttt = ttt;
                            ttt.startGame();
                        }
                        break;
                    case "END_ALL":
                        ttt.parse(this, message);
                        ttt = null;
                        js.remove(this);
                        break;
                    case "END":
                        ttt.parse(this, message);
                        ttt = null;
                        break;
                    default:
                        ttt.parse(this, message);
                        break;
                }
                break;
            }
    } 
  
  private void sendToAll(String message) {
        js.forEach((user) -> {
            user.out.println(message);
        });
    }
    
    private void sendToUser(String username, String message) {
        js.forEach((user) -> {
            if (user.name.equals(username))
                user.out.println(message);
        });
    }
    
    private JabberServer findUser(String username) {
        for (JabberServer user: js) {
            if (user.name!=null && user.name.equals(username))
                return user;
        }
        return null;
    }
}
