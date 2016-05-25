package com.matthewyao.sikuli;

import org.sikuli.script.*;

/**
 * Created by matthewyao on 2016/5/24.
 */
public class JavaSikuliDemo {
    public static void execute(){
        Screen screen = new Screen();
        String imgPath = "E:/sikuli.image";
        try {
            screen.doubleClick(imgPath + "chrome.png");
            screen.type(imgPath+"url_input.png","www.pptv.com");
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
}
