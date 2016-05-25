package com.matthewyao.sikuli;

import org.sikuli.script.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by matthewyao on 2016/5/24.
 */
public class JavaSikuliDemo {

    private static String imgPath = "E:\\sikuli.image\\";

    public static void execute(){
        Screen screen = new Screen();
        try {
            screen.doubleClick(url("chrome"));
            screen.paste(url("url_input"),"moni.51hupai.org/?new=13");
            screen.type("\n");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Rectangle r = screen.find(url("range")).getRect();
            int x = (int)(r.getX()+r.getWidth()) + 5 ;
            int y = (int)(r.getY());
            int h = (int)r.getHeight() - 5;
            BufferedImage image = screen.capture(x,y,100,h).getImage();
            saveImg(image);
            screen.paste(url("price"),"85200");
            screen.click(url("bid"));
//            if (screen.exists(url("confirm"))){
//                screen.click(url("confirm"));
//            }
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    private static String url(String imgUrl){
        return imgPath + imgUrl + ".png";
    }

    private static void saveImg(BufferedImage image){
        File file = new File(imgPath + "price_range.png");
        try {
            ImageIO.write(image,"png",file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
