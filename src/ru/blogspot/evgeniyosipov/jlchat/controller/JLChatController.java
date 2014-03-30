package ru.blogspot.evgeniyosipov.jlchat.controller;

import ru.blogspot.evgeniyosipov.jlchat.model.JLChatModel;
import ru.blogspot.evgeniyosipov.jlchat.view.JLChatView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Evgeniy Osipov (osipoveg1990@gmail.com, http://evgeniyosipov.blogspot.ru/)
 * @version 1.0
 */
public class JLChatController {

    public static synchronized void startServerSockets() {
        try {
            JLChatModel.setServerSocket(new ServerSocket(JLChatModel.getServerPort()));
            JLChatModel.setSocket(JLChatModel.getServerSocket().accept());

            JLChatModel.setBegin(false);
            JLChatModel.setConnect(true);

            JLChatModel.setBr(new BufferedReader(new InputStreamReader(JLChatModel.getSocket().getInputStream(), "UTF-8")));
            JLChatModel.setBw(new BufferedWriter(new OutputStreamWriter(JLChatModel.getSocket().getOutputStream(), "UTF-8")));

            JLChatView.getjTextArea2().setEnabled(true);
            JLChatView.getjButton3().setEnabled(true);

        } catch (IOException ex) {
            Logger.getLogger(JLChatView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static synchronized void startClientSockets() {
        try {
            JLChatModel.setSocket(new Socket(JLChatModel.getServerIP(), JLChatModel.getServerPort()));

            JLChatModel.setBegin(false);
            JLChatModel.setConnect(true);

            JLChatModel.setBr(new BufferedReader(new InputStreamReader(JLChatModel.getSocket().getInputStream(), "UTF-8")));
            JLChatModel.setBw(new BufferedWriter(new OutputStreamWriter(JLChatModel.getSocket().getOutputStream(), "UTF-8")));

            JLChatView.getjTextArea2().setEnabled(true);
            JLChatView.getjButton3().setEnabled(true);

        } catch (UnknownHostException ex) {
            Logger.getLogger(JLChatView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JLChatView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static synchronized void sendMessageMethod(String smmString) {
        JLChatModel.getSendMessage().append(JLChatModel.getUserName()).append(": ").append(smmString).append("\n");
    }

    public static synchronized void chatMessageMethod(String cmmString) {
        JLChatModel.getChatMessage().append(cmmString).append("\n");
    }

    public static synchronized void sendMessageSafe() {
        try {
            JLChatModel.getBw().write(JLChatModel.getSendMessage().toString());
            JLChatModel.getBw().flush();
            JLChatView.getjTextArea1().append(JLChatModel.getSendMessage().toString());
            JLChatModel.getSendMessage().setLength(0);
            JLChatView.getjTextArea2().setText("");

        } catch (IOException ex) {
            Logger.getLogger(JLChatView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static synchronized void chatMessageSafe() {
        try {
            JLChatModel.setSafeChatString(JLChatModel.getBr().readLine());
        } catch (IOException ex) {
            Logger.getLogger(JLChatView.class.getName()).log(Level.SEVERE, null, ex);
        }
        chatMessageMethod(JLChatModel.getSafeChatString());
        JLChatView.getjTextArea1().append(JLChatModel.getChatMessage().toString());
        JLChatModel.getChatMessage().setLength(0);
    }

}
