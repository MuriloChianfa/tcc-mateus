package com.example.teste.Network;

import android.os.Handler;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client extends Thread
{
    String remoteAddress;
    IOStream stream;

    Handler handler;

    public Client(InetAddress hostAddress, Handler handler)
    {
        remoteAddress = hostAddress.getHostAddress();
        this.handler = handler;
    }

    @Override
    public void run()
    {
        try {
            Socket socket = new Socket();

            socket.connect(new InetSocketAddress(remoteAddress, 8888), 8);

            stream = new IOStream(socket, this.handler);

            stream.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
