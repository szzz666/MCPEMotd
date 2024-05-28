package top.szzz666;


//MOTD: MCPE;§l§bStarrysky§uGame;671;1.20.80;7;100;-2057556455526391459;§l§bStarrysky§uGame;Survival;1
public class MotdData {
    private boolean online;
    private String host;
    private int port;
    private int ping_time;
    private String ip_address;
    private String version_name;
    private String version_protocol;

    private String players_online;
    private String players_max;
    private String motd_raw;
    private String motd_clean;
    private String motd_html;
    private String gamemode;//Survival

    private String server_id;//-2057556455526391459
    private String edition;//MCPE


    public MotdData() {
    }

    public MotdData(boolean online, String host, int port, String ip_address, String version_name, String version_protocol, String players_online, String players_max, String motd_raw, String motd_clean, String motd_html, String gamemode, String server_id, String edition) {
        this.online = online;
        this.host = host;
        this.port = port;
        this.ip_address = ip_address;
        this.version_name = version_name;
        this.version_protocol = version_protocol;
        this.players_online = players_online;
        this.players_max = players_max;
        this.motd_raw = motd_raw;
        this.motd_clean = motd_clean;
        this.motd_html = motd_html;
        this.gamemode = gamemode;
        this.server_id = server_id;
        this.edition = edition;
    }

    public MotdData(boolean online, String host, int port, int ping_time, String ip_address, String version_name, String version_protocol, String players_online, String players_max, String motd_raw, String motd_clean, String motd_html, String gamemode, String server_id, String edition) {
        this.online = online;
        this.host = host;
        this.port = port;
        this.ping_time = ping_time;
        this.ip_address = ip_address;
        this.version_name = version_name;
        this.version_protocol = version_protocol;
        this.players_online = players_online;
        this.players_max = players_max;
        this.motd_raw = motd_raw;
        this.motd_clean = motd_clean;
        this.motd_html = motd_html;
        this.gamemode = gamemode;
        this.server_id = server_id;
        this.edition = edition;
    }

    /**
     * 获取
     * @return online
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * 设置
     * @param online
     */
    public void setOnline(boolean online) {
        this.online = online;
    }

    /**
     * 获取
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * 设置
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 获取
     * @return port
     */
    public int getPort() {
        return port;
    }

    /**
     * 设置
     * @param port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * 获取
     * @return ip_address
     */
    public String getIp_address() {
        return ip_address;
    }

    /**
     * 设置
     * @param ip_address
     */
    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    /**
     * 获取
     * @return version_name
     */
    public String getVersion_name() {
        return version_name;
    }

    /**
     * 设置
     * @param version_name
     */
    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    /**
     * 获取
     * @return version_protocol
     */
    public String getVersion_protocol() {
        return version_protocol;
    }

    /**
     * 设置
     * @param version_protocol
     */
    public void setVersion_protocol(String version_protocol) {
        this.version_protocol = version_protocol;
    }

    /**
     * 获取
     * @return players_online
     */
    public String getPlayers_online() {
        return players_online;
    }

    /**
     * 设置
     * @param players_online
     */
    public void setPlayers_online(String players_online) {
        this.players_online = players_online;
    }

    /**
     * 获取
     * @return players_max
     */
    public String getPlayers_max() {
        return players_max;
    }

    /**
     * 设置
     * @param players_max
     */
    public void setPlayers_max(String players_max) {
        this.players_max = players_max;
    }

    /**
     * 获取
     * @return motd_raw
     */
    public String getMotd_raw() {
        return motd_raw;
    }

    /**
     * 设置
     * @param motd_raw
     */
    public void setMotd_raw(String motd_raw) {
        this.motd_raw = motd_raw;
    }

    /**
     * 获取
     * @return motd_clean
     */
    public String getMotd_clean() {
        return motd_clean;
    }

    /**
     * 设置
     * @param motd_clean
     */
    public void setMotd_clean(String motd_clean) {
        this.motd_clean = motd_clean;
    }

    /**
     * 获取
     * @return motd_html
     */
    public String getMotd_html() {
        return motd_html;
    }

    /**
     * 设置
     * @param motd_html
     */
    public void setMotd_html(String motd_html) {
        this.motd_html = motd_html;
    }

    /**
     * 获取
     * @return gamemode
     */
    public String getGamemode() {
        return gamemode;
    }

    /**
     * 设置
     * @param gamemode
     */
    public void setGamemode(String gamemode) {
        this.gamemode = gamemode;
    }

    /**
     * 获取
     * @return server_id
     */
    public String getServer_id() {
        return server_id;
    }

    /**
     * 设置
     * @param server_id
     */
    public void setServer_id(String server_id) {
        this.server_id = server_id;
    }

    /**
     * 获取
     * @return edition
     */
    public String getEdition() {
        return edition;
    }

    /**
     * 设置
     * @param edition
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String toString() {
        return "MotdData{online = " + online + ", host = " + host + ", port = " + port + ", ip_address = " + ip_address + ", version_name = " + version_name + ", version_protocol = " + version_protocol + ", players_online = " + players_online + ", players_max = " + players_max + ", motd_raw = " + motd_raw + ", motd_clean = " + motd_clean + ", motd_html = " + motd_html + ", gamemode = " + gamemode + ", server_id = " + server_id + ", edition = " + edition + "}";
    }

    /**
     * 获取
     * @return ping_time
     */
    public int getPing_time() {
        return ping_time;
    }

    /**
     * 设置
     * @param ping_time
     */
    public void setPing_time(int ping_time) {
        this.ping_time = ping_time;
    }
}