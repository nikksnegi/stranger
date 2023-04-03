package com.talk.to.Strangers.SocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public  class SocketServer {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static PrintWriter out;
    private static int port;
    private static BufferedReader in;

    SocketServer() {
    }

    public SocketServer(int port) {
        this.port = port;
    }

    public  void start() {
        try {
            // create server socket
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server started on port " + port);

            while (true) {
                // accept client connection
                Socket clientSocket = serverSocket.accept();

                // create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // read input from client
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    // process input
                    System.out.println("Received message from client: " + inputLine);

                }

                // close streams and socket
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port 8080 or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
