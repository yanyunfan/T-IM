package com.tim.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.websocket.server.WsServerAioListener;

/**
 * 用户根据情况来完成该类的实现
 */
public class ShowcaseServerAioListener extends WsServerAioListener {
    private static Logger log = LoggerFactory.getLogger(ShowcaseServerAioListener.class);

    public static final ShowcaseServerAioListener me = new ShowcaseServerAioListener();

    private ShowcaseServerAioListener() {

    }

    @Override
    public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect) throws Exception {
        super.onAfterConnected(channelContext, isConnected, isReconnect);
        log.debug("onAfterConnected\r\n{}", channelContext);

    }

    @Override
    public void onAfterSent(ChannelContext channelContext, Packet packet, boolean isSentSuccess) throws Exception {
        super.onAfterSent(channelContext, packet, isSentSuccess);
        log.debug("onAfterSent\r\n{}\r\n{}", packet.logstr(), channelContext);
    }

    @Override
    public void onBeforeClose(ChannelContext channelContext, Throwable throwable, String remark, boolean isRemove) throws Exception {
        super.onBeforeClose(channelContext, throwable, remark, isRemove);
        log.debug("onBeforeClose\r\n{}", channelContext);
    }

    @Override
    public void onAfterDecoded(ChannelContext channelContext, Packet packet, int packetSize) throws Exception {
        super.onAfterDecoded(channelContext, packet, packetSize);
        log.debug("onAfterDecoded\r\n{}\r\n{}", packet.logstr(), channelContext);
    }

    @Override
    public void onAfterReceivedBytes(ChannelContext channelContext, int receivedBytes) throws Exception {
        super.onAfterReceivedBytes(channelContext, receivedBytes);
        log.debug("onAfterReceivedBytes\r\n{}", channelContext);
    }

    @Override
    public void onAfterHandled(ChannelContext channelContext, Packet packet, long cost) throws Exception {
        super.onAfterHandled(channelContext, packet, cost);
        log.debug("onAfterHandled\r\n{}\r\n{}", packet.logstr(), channelContext);
    }

}
