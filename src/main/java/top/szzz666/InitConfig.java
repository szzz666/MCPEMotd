package top.szzz666;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class InitConfig {
//    public static String File = "src/main/resources/";
    public static String File = "";
    public static int httpServerPort = 8662;
    public static int httpsServerPort = 8663;
    public static boolean useHttpServer = true;
    public static boolean useHttpsServer = false;
    public static String keystorePass = "";
    public static String keystorePassFile = "keystore.jks";
    public static boolean useSaveLogs = false;
    public static String thePathOfTheRequest = "/motd";


    public static void getconfig() {

        HashMap<String, String> data;
        Yaml yaml = new Yaml();
        try {
            // 读取 YAML 文件
            FileInputStream fis = new FileInputStream(File + "config/config.yml");
            data = yaml.load(fis);
            httpServerPort = Integer.parseInt(data.get("HttpServerPort"));
            httpsServerPort = Integer.parseInt(data.get("HttpsServerPort"));
            useHttpServer = Boolean.parseBoolean(data.get("UseHttpServer"));
            useHttpsServer = Boolean.parseBoolean(data.get("UseHttpsServer"));
            keystorePass = data.get("keystorePass");
            keystorePassFile = data.get("keystorePassFile");
            useSaveLogs = Boolean.parseBoolean(data.get("UseSaveLogs"));
            thePathOfTheRequest = data.get("ThePathOfTheRequest");

        } catch (FileNotFoundException e) {
            // 处理文件未找到异常
            System.err.println("[错误]没有找到配置文件：config.yml");
        }

    }

    public static HashMap<String, String> getStyleMap() {
        HashMap<String, String> data = new HashMap<>();
        Yaml yaml = new Yaml();
        try {
            // 读取 YAML 文件
            FileInputStream fis = new FileInputStream(File + "config/config_style.yml");
            data = yaml.load(fis);
        } catch (FileNotFoundException e) {
            // 处理文件未找到异常
            System.err.println("[错误]没有找到配置文件：config_style.yml");
        }
        return data;
    }
}