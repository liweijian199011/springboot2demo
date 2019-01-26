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
                    // accept方法一定要放在while循环里面，因为accept方法是一个阻塞方法
                    // 一个客户端连接之后，才会执行accept方法后面的逻辑。一个客户端连接连接成功之后
                    // 就会创建一个线程来读取数据。
                    // 但是如果将accept方法放在while循环之外，则main函数所在的线程就会报oom错误。
                    // 因为accept方法是阻塞的，一旦客户端连接成功之后，就开始执行无限循环，瞬间就会创建很多线程，就会内存溢出。
                    // 自然主线程就会报oom异常。
                    // 但是accept方法放在循环里面，则一个客户端连接成功之后，则又会执行accept方法，又会阻塞，就不会创建大量的线程，就不会报oom。
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