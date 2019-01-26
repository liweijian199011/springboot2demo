package com.jack.socket;

import java.net.Socket;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/1/20.
 *
 * @author liweijian.
 */
public class IOClient2 {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    socket.getOutputStream().write((new Date() + " hello, world2").getBytes());
                    socket.getOutputStream().flush();
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }).start();
    }
}
