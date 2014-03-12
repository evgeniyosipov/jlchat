package me.evgeniyosipov.jlchat.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Evgeniy Osipov (osipoveg1990@gmail.com, http://evgeniyosipov.me)
 * @version 1.0
 */
public class JLChatModel {

    private static String serverIP;
    private static int serverPort;
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static String userName;
    private static String safeChatString;
    private static StringBuffer sendMessage = new StringBuffer("");
    private static StringBuffer chatMessage = new StringBuffer("");
    private static BufferedWriter bw;
    private static BufferedReader br;
    private static boolean begin;
    private static boolean connect;

    /**
     * @return the serverIP
     */
    public static String getServerIP() {
        return serverIP;
    }

    /**
     * @param aServerIP the serverIP to set
     */
    public static void setServerIP(String aServerIP) {
        serverIP = aServerIP;
    }

    /**
     * @return the serverPort
     */
    public static int getServerPort() {
        return serverPort;
    }

    /**
     * @param aServerPort the serverPort to set
     */
    public static void setServerPort(int aServerPort) {
        serverPort = aServerPort;
    }

    /**
     * @return the serverSocket
     */
    public static ServerSocket getServerSocket() {
        return serverSocket;
    }

    /**
     * @param aServerSocket the serverSocket to set
     */
    public static void setServerSocket(ServerSocket aServerSocket) {
        serverSocket = aServerSocket;
    }

    /**
     * @return the socket
     */
    public static Socket getSocket() {
        return socket;
    }

    /**
     * @param aSocket the socket to set
     */
    public static void setSocket(Socket aSocket) {
        socket = aSocket;
    }

    /**
     * @return the userName
     */
    public static String getUserName() {
        return userName;
    }

    /**
     * @param aUserName the userName to set
     */
    public static void setUserName(String aUserName) {
        userName = aUserName;
    }

    /**
     * @return the safeChatString
     */
    public static String getSafeChatString() {
        return safeChatString;
    }

    /**
     * @param aSafeChatString the safeChatString to set
     */
    public static void setSafeChatString(String aSafeChatString) {
        safeChatString = aSafeChatString;
    }

    /**
     * @return the sendMessage
     */
    public static StringBuffer getSendMessage() {
        return sendMessage;
    }

    /**
     * @param aSendMessage the sendMessage to set
     */
    public static void setSendMessage(StringBuffer aSendMessage) {
        sendMessage = aSendMessage;
    }

    /**
     * @return the chatMessage
     */
    public static StringBuffer getChatMessage() {
        return chatMessage;
    }

    /**
     * @param aChatMessage the chatMessage to set
     */
    public static void setChatMessage(StringBuffer aChatMessage) {
        chatMessage = aChatMessage;
    }

    /**
     * @return the bw
     */
    public static BufferedWriter getBw() {
        return bw;
    }

    /**
     * @param aBw the bw to set
     */
    public static void setBw(BufferedWriter aBw) {
        bw = aBw;
    }

    /**
     * @return the br
     */
    public static BufferedReader getBr() {
        return br;
    }

    /**
     * @param aBr the br to set
     */
    public static void setBr(BufferedReader aBr) {
        br = aBr;
    }

    /**
     * @return the begin
     */
    public static boolean isBegin() {
        return begin;
    }

    /**
     * @param aBegin the begin to set
     */
    public static void setBegin(boolean aBegin) {
        begin = aBegin;
    }

    /**
     * @return the connect
     */
    public static boolean isConnect() {
        return connect;
    }

    /**
     * @param aConnect the connect to set
     */
    public static void setConnect(boolean aConnect) {
        connect = aConnect;
    }

}
