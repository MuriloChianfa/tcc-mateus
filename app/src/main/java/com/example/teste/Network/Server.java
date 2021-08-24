package com.example.teste.Network;

import android.os.Handler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread
{
    public IOStream stream;
    Handler handler;

    public Server(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run()
    {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);

            Socket socket = serverSocket.accept();

            this.stream = new IOStream(socket, handler);

            this.stream.start();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
