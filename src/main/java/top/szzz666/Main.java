package top.szzz666;


import top.szzz666.WebService.MyHttpServer;
import top.szzz666.WebService.MyHttpsServer;

import static top.szzz666.InitConfig.*;
import static top.szzz666.LogToFile.formatTime;

public class Main {

    public static void main(String[] args) throws Exception {
        if (InitConfig.useSaveLogs){
            LogToFile.initLog();
        }
        getconfig();
        System.out.println(" __  __  ___ ___ ___ __  __     _      _ ");
        System.out.println("|  \\/  |/ __| _ ) __|  \\/  |___| |_ __| |");
        System.out.println("| |\\/| | (__| _ \\ _|| |\\/| / _ \\  _/ _` |");
        System.out.println("|_|  |_|\\___|___/___|_|  |_\\___/\\__\\__,_|");
        System.out.println("开发者QQ：3214948198（初学者写的烂，请不要喷）");
        System.out.println("开发者邮箱：3214948198@qq.com");
        System.out.println("更新地址：https://www.minebbs.com/resources/mcbemotd.8181/");

        if (InitConfig.useHttpServer) {
            MyHttpServer.httpServer(httpServerPort, thePathOfTheRequest);
            System.out.println(formatTime() + "HTTP服务已经启动，访问地址：");
            System.out.println(formatTime() + "http://localhost:" + httpServerPort + thePathOfTheRequest + "?serverIp=serverIp:serverPort");
        }
        if (InitConfig.useHttpsServer) {
            MyHttpsServer.httpServer(httpsServerPort, thePathOfTheRequest);
            System.out.println(formatTime() + "HTTPS服务已经启动，访问地址：");
            System.out.println(formatTime() + "https://localhost:" + httpsServerPort + thePathOfTheRequest + "?serverIp=serverIp:serverPort");
        }

        System.out.println("-----------------------------------------------------------------------------------");
    }


}