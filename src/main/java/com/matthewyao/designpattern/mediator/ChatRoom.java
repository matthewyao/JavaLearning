package com.matthewyao.designpattern.mediator;

import java.util.Date;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class ChatRoom {
    public void pushMessage(String message, User user) {
        System.out.println(String.format("%s [%s]: %s", new Date().toString(), user.getName(), message));
    }
}
