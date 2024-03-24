package com.p2p;

/**
 * Represents a message used in peer-to-peer communication.
 */
public class Message {

    // Attributes of the message
    private int length; // Length of the message
    private byte type; // Type of the message
    private byte[] payload; // Payload data of the message

    private MessageTypes typeEnum;

    /**
     * Constructs a new Message object with the specified length, type, and payload.
     */
    public Message(int length, byte type, byte[] payload) {

        this.length = length;
        this.type = type;
        this.payload = payload;
    }

    // Getters and setters for message attributes

    /**
     * Gets the length of the message.
     */
    public int getLength() {

        return length;
    }

    /**
     * Sets the length of the message.
     */
    public void setLength(int length) {

        this.length = length;
    }

    /**
     * Gets the type of the message.
     */
    public byte getType() {

        return type;
    }

    /**
     * Sets the type of the message.
     */
    public void setType(byte type) {

        this.type = type;
    }

    /**
     * Gets the payload data of the message.
     */
    public byte[] getPayload() {

        return payload;
    }

    /**
     * Sets the payload data of the message.
     */
    public void setPayload(byte[] payload) {

        this.payload = payload;
    }

    /**
     * Check if the length field matches the actual length of the payload
     */
    public boolean isValid() {
        return length == payload.length;
    }
}
