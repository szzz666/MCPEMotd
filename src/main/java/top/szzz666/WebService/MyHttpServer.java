package top.szzz666.WebService;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;



public class MyHttpServer {
    public static void httpServer(int httpPort,String thePathOfTheRequest) throws Exception {
        // 创建并绑定HTTP服务器到本地的8000端口，第二个参数表示连接队列长度，0表示使用默认值
        HttpServer server = HttpServer.create(new InetSocketAddress(httpPort), 0);

        // 设置处理"/test"路径请求的处理器，这里使用自定义的MyHandler类
        server.createContext(thePathOfTheRequest, new MyHttpHandler());

        // 设置服务器的执行器为null，意味着使用其默认的执行策略（通常是一个基于线程池的执行器）
        server.setExecutor(null);

        // 启动服务器
        server.start();

    }

}

