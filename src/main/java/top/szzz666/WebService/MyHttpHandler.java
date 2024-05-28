package top.szzz666.WebService;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import static top.szzz666.LogToFile.formatTime;
import static top.szzz666.Motd.handleMotd;


public class MyHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // 获取请求方法
        String requestMethod = exchange.getRequestMethod();

        /// 获取客户端IP
        InetSocketAddress clientAddress = exchange.getRemoteAddress();
        String clientIp = clientAddress.getAddress().getHostAddress();

        if (requestMethod.equalsIgnoreCase("GET")) {
            System.out.println(formatTime() + "接到来自" + clientIp + "请求");
            // 获取查询参数
            String query = exchange.getRequestURI().getQuery();
            System.out.println(formatTime() + "获得请求参数：" + query);

            // 解析查询参数
            String serverIp = null;
            int serverPort = 19132;
            String motdJson = null;
            String[] params = query.split("=");
            if (params[0].equals("serverIp")) {
                if (!params[1].contains(":")) {
                    serverIp = params[1];
                    System.out.println(formatTime() + "解析获得IP：" + params[1]);
                    System.out.println(formatTime() + "解析获得端口：19132");
                } else {
                    String[] params2 = params[1].split(":");
                    System.out.println(formatTime() + "解析获得IP：" + params2[0]);
                    System.out.println(formatTime() + "解析获得端口：" + params2[1]);
                    serverIp = params2[0];
                    serverPort = Integer.parseInt(params2[1]);
                }

                // 处理MOTD并生成JSON
                motdJson = handleMotd(serverIp, serverPort);
            } else {
                System.err.println(formatTime() + query + "是错误参数");
            }


            // 设置响应头
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            if (motdJson != null) {
                exchange.sendResponseHeaders(200, motdJson.getBytes().length);
                // 发送响应
                OutputStream responseBody = exchange.getResponseBody();

                responseBody.write(motdJson.getBytes());

                responseBody.close();

                System.out.println(formatTime() + "已经返回JSON");
            } else {
                // 不支持的请求方法
                exchange.sendResponseHeaders(405, 0);
                System.out.println(formatTime() + "不支持的请求");

            }
            System.out.println("-----------------------------------------------------------------------------------");
        }

    }
}

