package com.p2p;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Handles sending and receiving messages over a socket connection.
 */
public class MessageHandler {
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    /**
     * Constructs a MessageHandler instance with the specified socket.
     *
     * @param socket The socket for sending and receiving messages.
     * @throws IOException If an I/O error occurs while creating the input/output streams.
     */
    public MessageHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
        this.inputStream = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * Sends a message over the socket connection.
     *
     * @param message The message object to be sent.
     * @throws IOException If an I/O error occurs while sending the message.
     */
    public void sendMessage(Message message) throws IOException {
        outputStream.writeObject(message);
        outputStream.flush();
    }

    /**
     * Receives a message from the socket connection.
     *
     * @return The received message object.
     * @throws IOException            If an I/O error occurs while receiving the message.
     * @throws ClassNotFoundException If the class of the serialized object could not be found.
     */
    public Message receiveMessage() throws IOException, ClassNotFoundException {
        try {
            return (Message) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Class not found while deserializing object.");
            throw e; // Re-throw the exception to propagate it up the call stack
        }
    }

    /**
     * Closes the input/output streams and the socket connection.
     *
     * @throws IOException If an I/O error occurs while closing the streams or socket.
     */
    public void close() throws IOException {
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
