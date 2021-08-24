package com.example.teste.Network;

import android.os.Handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class IOStream extends Thread
{
    public static final int MESSAGE_READ = 1;
    public static final int MESSAGE_WRITE = 2;

    private final Socket socket;
    private final Handler handler;

    private InputStream inputStream;
    private OutputStream outputStream;

    public IOStream(Socket skt, Handler handler)
    {
        this.socket = skt;
        this.handler = handler;

        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void run()
    {
        byte[] buffer = new byte[1024];
        int bytes;

        while (this.socket != null) {
            try {
                inputStream.reset();

                bytes = inputStream.read(buffer);

                if (bytes > 0) {
                    this.handler.obtainMessage(MESSAGE_READ, bytes, -1, buffer).sendToTarget();
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void write(byte[] bytes)
    {
        try {
            outputStream.write(bytes);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
