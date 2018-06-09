package com.matthewyao.designpattern.observer;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Client {
    public static void main(String[] args) {
        Transporter transporter = new Transporter();
        Police police = new Police();
        Security security = new Security();
        Thief thief = new Thief();

        transporter.addWatcher(police);
        transporter.addWatcher(security);
        transporter.addWatcher(thief);
        transporter.notifyWatchers();

        System.out.println("强盗发现前有保镖，后有警察，决定撤退");
        System.out.println();
        transporter.removeWatcher(thief);
        transporter.notifyWatchers();
    }
}
