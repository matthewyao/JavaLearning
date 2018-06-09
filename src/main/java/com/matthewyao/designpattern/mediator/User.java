package com.matthewyao.designpattern.mediator;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class User {
    private String name;
    private ChatRoom chatRoom;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }

    public void enterChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public void sendMessage(String message) {
        chatRoom.pushMessage(message, this);
    }
}
