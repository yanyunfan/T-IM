package com.tim;

import com.tim.config.ShowcaseServerConfig;
import com.tim.handler.ShowcaseWsMsgHandler;
import com.tim.listener.ShowcaseIpStatListener;
import com.tim.listener.ShowcaseServerAioListener;
import org.tio.server.ServerTioConfig;
import org.tio.utils.jfinal.P;
import org.tio.websocket.server.WsServerStarter;

/**
 * 启动类
 */
public class ShowcaseWebsocketStarter {
    private WsServerStarter wsServerStarter;
    private ServerTioConfig serverTioConfig;

    public ServerTioConfig getServerTioConfig() {
        return serverTioConfig;
    }

    public WsServerStarter getWsServerStarter() {
        return wsServerStarter;
    }

    public ShowcaseWebsocketStarter(int port, ShowcaseWsMsgHandler wsMsgHandler) throws Exception {
        wsServerStarter = new WsServerStarter(port, wsMsgHandler);

        serverTioConfig = wsServerStarter.getServerTioConfig();
        serverTioConfig.setName(ShowcaseServerConfig.PROTOCOL_NAME);
        serverTioConfig.setServerAioListener(ShowcaseServerAioListener.me);

        // 设置ip监控
        serverTioConfig.setIpStatListener(ShowcaseIpStatListener.me);
        // 设置ip统计时间段
        serverTioConfig.ipStats.addDurations(ShowcaseServerConfig.IpStatDuration.IPSTAT_DURATIONS);

        // 设置心跳超时时间
        serverTioConfig.setHeartbeatTimeout(ShowcaseServerConfig.HEARTBEAT_TIMEOUT);
    }


    public static void main(String[] args) throws Exception {
        P.use("app.properties");

        // 启动websocket server
        ShowcaseWebsocketStarter appStarter = new ShowcaseWebsocketStarter(P.getInt("server.port"), ShowcaseWsMsgHandler.me);
        appStarter.wsServerStarter.start();
    }

}
