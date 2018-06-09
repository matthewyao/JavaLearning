package com.matthewyao.designpattern.memento;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("#1");
        printCurrentState(originator);

        originator.setState("#2");
        printCurrentState(originator);
        careTaker.saveState(originator.saveStateToMemen());

        originator.setState("#3");
        printCurrentState(originator);
        careTaker.saveState(originator.saveStateToMemen());

        originator.setState("#4");
        printCurrentState(originator);
        //restore to savepoint 0
        originator.restoreStateFromMemto(careTaker.get(0));
        System.out.println("Restore to state:" + originator.getState());
        //proceeding
        originator.setState("#5");
        printCurrentState(originator);
        //restore to savepoint 1
        originator.restoreStateFromMemto(careTaker.get(1));
        System.out.println("Restore to state: " + originator.getState());

        originator.setState("#6");
        printCurrentState(originator);
    }

    private static void printCurrentState(Originator originator) {
        System.out.println("Current state: " + originator.getState());
    }
}
