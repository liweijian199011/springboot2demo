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
        ServerSocket server = new ServerSocket(8000);

        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = server.accept();

                    new Thread(() -> {
                        try {
                            byte[] bytes = new byte[64];
                            InputStream inputStream = socket.getInputStream();
                            while (true) {
                                int length;
                                while ((length = inputStream.read(bytes)) != -1) {
                                    System.out.println(new String(bytes, 0, length));
                                }
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }).start();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

}
