package com.matthewyao.designpattern.mediator;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Client {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        User john = new User("John");
        User tom = new User("Tom");
        john.enterChatRoom(chatRoom);
        tom.enterChatRoom(chatRoom);

        john.sendMessage("Hello tom!");
        tom.sendMessage("Hi John, how are u today?");
        john.sendMessage("Never mention about it, I've been fired.");
        tom.sendMessage("Don't be so sad, I believe you can find a better one!");
        john.sendMessage("Thanks, yours words really help!");
        john.sendMessage("I'm gonna have a drink and forget about it, bye.");
        tom.sendMessage("Ok, See u.");
    }
}
