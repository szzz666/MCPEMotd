package top.szzz666.WebService;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;

import static top.szzz666.InitConfig.*;


public class MyHttpsServer {
    public static void httpServer(int httpsPort,String thePathOfTheRequest) throws Exception {
        // 创建并初始化一个HTTPS服务器实例
        HttpsServer server = HttpsServer.create(new InetSocketAddress(httpsPort), 0);

        // 配置SSL上下文，包括密钥管理器和信任管理器
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(loadKeyManagers().getKeyManagers(), loadTrustManagers().getTrustManagers(), null);

        // 使用配置好的SSL上下文来创建HTTPS配置器
        HttpsConfigurator httpsConfigurator = new HttpsConfigurator(sslContext);
        server.setHttpsConfigurator(httpsConfigurator);

        // 设置处理请求的处理器，并绑定到"/test"路径
        server.createContext(thePathOfTheRequest, new MyHttpHandler());

        // 使用默认的线程池处理请求
        server.setExecutor(null);
        server.start();

    }
    //加载密钥管理器，用于管理服务器的私钥和证书
    private static KeyManagerFactory loadKeyManagers() throws Exception {
        // 密钥库密码
        char[] password = keystorePass.toCharArray();
        // 实例化KeyStore，类型为JKS（Java Key Store）
        KeyStore ks = KeyStore.getInstance("JKS");

        // 从文件中加载密钥库
        FileInputStream fis = new FileInputStream(File + keystorePassFile);
        ks.load(fis, password);
        fis.close();

        // 初始化密钥管理器
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(ks, password);
        return kmf;
    }

    // 加载信任管理器，这里为了示例简单，信任所有证书
    private static TrustManagerFactory loadTrustManagers() throws Exception {
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        // 直接初始化为空，意味着信任任何证书，生产环境中应根据实际情况配置信任哪些证书
        tmf.init((KeyStore)null);
        return tmf;
    }


}

