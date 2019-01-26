package com.jack.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/1/20.
 *
 * @author liweijian.
 */
public class IOServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);

        new Thread(() -> {
            try {
                while (true) {
                    Socket socket = serverSocket.accept();

                    new Thread(() -> {
                        try {
                            InputStream is = socket.getInputStream();
                            byte[] bytes = new byte[64];
                            int len;
                            while ((len = is.read(bytes)) != -1) {
                                System.out.println(new String(bytes, 0, len));
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }).start();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}