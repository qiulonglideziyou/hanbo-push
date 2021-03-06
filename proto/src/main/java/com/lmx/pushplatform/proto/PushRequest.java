package com.lmx.pushplatform.proto;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PushRequest {
    private String requestId;
    private int msgType;//0=注册，1=消息,2=内部事件（路由转发）,3=心跳
    private int pushType = 1;//1=推送，2=IM
    private int platform = 1;//默认1=安卓，2=ios，0=全平台
    private String fromId;
    private List<String> toId;
    private String msgContent;
    private String appKey;
    private String topic;//ios推送必传
    private static final AtomicInteger atomicInteger = new AtomicInteger(1);

    public enum Platform {
        NULL, ANDROID, IOS, WEB, ALL
    }

    public enum PushType {
        NULL, PUSH, IM

    }

    public enum MessageType {
        REGISTY, DILIVERY_MSG, ROUTER_FORWARD, HEARTBEAT, NIL;

        public static MessageType getMessageType(int type) {
            switch (type) {
                case 0:
                    return REGISTY;
                case 1:
                    return DILIVERY_MSG;
                case 2:
                    return ROUTER_FORWARD;
                case 3:
                    return HEARTBEAT;
                default:
                    return NIL;
            }
        }
    }

    public PushRequest() {
        int seq = atomicInteger.incrementAndGet();
        if (seq < 0) {
            atomicInteger.set(0);
            seq = atomicInteger.incrementAndGet();
        }
        requestId = String.valueOf(seq);
    }

    @Override
    public String toString() {
        return "PushRequest{" +
                "requestId='" + requestId + '\'' +
                ", msgType=" + msgType +
                ", pushType=" + pushType +
                ", platform=" + platform +
                ", fromId='" + fromId + '\'' +
                ", toId=" + toId +
                ", msgContent='" + msgContent + '\'' +
                ", appKey='" + appKey + '\'' +
                '}';
    }

    public int getPushType() {
        return pushType;
    }

    public void setPushType(int pushType) {
        this.pushType = pushType;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public List<String> getToId() {
        return toId;
    }

    public void setToId(List<String> toId) {
        this.toId = toId;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public static AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
