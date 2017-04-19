/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Maria
 */
public class Client2 extends Thread{

    private Socket socket;
    private BufferedReader in;
    public PrintWriter    out;
    
    private InetAddress address;
    private int port;
    
    private boolean running = true;
    
    public interface Listener {
        public void onMessage(String message);
    }
    private final List<Listener> listeners_;

    public void addListener(Listener listener) {
        listeners_.add(listener);
    }
    
    public Client2() {
        listeners_ = new ArrayList<>();
    }
    
    public boolean config(String address, int port) {
        try {
            if (socket!=null) try { socket.close(); } catch (IOException ex1) {}
            this.address = InetAddress.getByName(address);
            this.port = port;
            socket = new Socket(address, port);
            if (socket.isConnected()) {
                System.out.println("Connected: " + socket);
                return true;
            }        
        } catch (Exception ex) {
            if (socket!=null) try { socket.close(); } catch (IOException ex1) {}
        }
        listeners_.forEach((listener) -> {
            listener.onMessage("CLIENT#DISCONNECTED");
        });
        return false;
    }
    
    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader( socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);
            listeners_.forEach((listener) -> {
                listener.onMessage("CLIENT#CONNECTED");
            });
            while (running) {
                try {
                    String string = in.readLine();
                    parse(string);
                } catch (IOException ex) {
                }
            }
        } catch (Exception ex) {
            if (socket!=null) try { socket.close(); } catch (IOException ex1) {}
            running = false;
        }
        listeners_.forEach((listener) -> {
            listener.onMessage("CLIENT#DISCONNECTED");
        });
    }
    
    public void disconnect() {
        running = false;
    }
    
    private void parse(String message) {
        System.out.println("Got message: "+message);
        listeners_.forEach((listener) -> {
            listener.onMessage(message);
        });
    }
}
