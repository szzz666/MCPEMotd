package top.szzz666;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

import static top.szzz666.LogToFile.formatTime;


public class Motd {
    public static String handleMotd(String serverIp, int serverPort) {
        final byte[] MOTD_DATA = new byte[]{1, 0, 0, 0, 0, 0, 3, 106, 7, 0, -1, -1, 0, -2, -2, -2, -2, -3, -3, -3, -3, 18, 52, 86, 120, -100, 116, 22, -68};


        String motd = null;
        String json = null;
        InetAddress inetAddress = null;
        long pingTime = 0;
        MotdData motdData = new MotdData();
//        String serverIp = "mc.szzz666.top";
//        int serverPort = 19132;

        try {
            long startTime = System.currentTimeMillis();
            // 解析域名为IP地址
            inetAddress = InetAddress.getByName(serverIp);
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(5000);
            DatagramPacket packet = new DatagramPacket(MOTD_DATA, MOTD_DATA.length, InetAddress.getByName(serverIp), serverPort);
            socket.send(packet);
            byte[] buffer = new byte[1024];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            long endTime = System.currentTimeMillis();
            pingTime = endTime - startTime;

            motd = new String(packet.getData(), 35, packet.getLength(), StandardCharsets.UTF_8);
            System.out.println(formatTime() + "已获得服务器信息");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (motd != null) {
            String[] motdArray = motd.split(";");

            motdData.setEdition(motdArray[0]);
            motdData.setMotd_raw(motdArray[1]);
            motdData.setVersion_protocol(motdArray[2]);
            motdData.setVersion_name(motdArray[3]);
            motdData.setPlayers_online(motdArray[4]);
            motdData.setPlayers_max(motdArray[5]);
            motdData.setServer_id(motdArray[6]);
            motdData.setGamemode(motdArray[8]);

            motdData.setOnline(true);
            motdData.setHost(serverIp);
            motdData.setPort(serverPort);

            motdData.setMotd_clean(motdArray[1].replaceAll("§[a-zA-Z]", ""));
            motdData.setMotd_html(ConvertToHTML.convertToHTML(motdArray[1]));
            motdData.setPing_time((int) pingTime);
            String[] IPparams = String.valueOf(inetAddress).split("/");
            motdData.setIp_address(IPparams[1]);

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将对象转换为JSON字符串
                json = objectMapper.writeValueAsString(motdData);

                System.out.println(formatTime() + "已经转换为JSON");
                String[] jsonArray = json.split(",");
                for (int i = 0; i < jsonArray.length; i++) {
                    if (i != jsonArray.length - 1) {
                        System.out.println(jsonArray[i] + ",");
                    } else {
                        System.out.println(jsonArray[i]);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return json;
    }
}
