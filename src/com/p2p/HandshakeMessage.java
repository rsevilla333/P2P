package com.p2p;

/**
 * Represents a handshake message used in peer-to-peer communication.
 */
public class HandshakeMessage {

    // Attributes of the handshake message
    private String handshakeHeader; // Header of the handshake message
    private int peerId; // ID of the peer associated with the handshake

    /**
     * Constructs a new HandshakeMessage object with the specified header and peer ID.
     */
    public HandshakeMessage(String handshakeHeader, int peerId) {

        this.handshakeHeader = handshakeHeader;
        this.peerId = peerId;
    }

    // Getters and setters for handshake message attributes

    /**
     * Gets the header of the handshake message.
     */
    public String getHandshakeHeader() {

        return handshakeHeader;
    }

    /**
     * Sets the header of the handshake message.
     */
    public void setHandshakeHeader(String handshakeHeader) {

        this.handshakeHeader = handshakeHeader;
    }

    /**
     * Gets the ID of the peer associated with the handshake.
     */
    public int getPeerId() {

        return peerId;
    }

    /**
     * Sets the ID of the peer associated with the handshake.
     */
    public void setPeerId(int peerId) {

        this.peerId = peerId;
    }
}
