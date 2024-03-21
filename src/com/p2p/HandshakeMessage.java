package com.p2p;

public class HandshakeMessage {
    private String handshakeHeader;
    private int peerId;

    public HandshakeMessage(String handshakeHeader, int peerId) {
        this.handshakeHeader = handshakeHeader;
        this.peerId = peerId;
    }

    // Getters and setters for handshake message attributes
    public String getHandshakeHeader() {
        return handshakeHeader;
    }

    public void setHandshakeHeader(String handshakeHeader) {
        this.handshakeHeader = handshakeHeader;
    }

    public int getPeerId() {
        return peerId;
    }

    public void setPeerId(int peerId) {
        this.peerId = peerId;
    }
}