package com.matthewyao.designpattern.state;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println("Context state: " + context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println("Context state: " + context.getState().toString());
    }
}
