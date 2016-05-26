package com.matthewyao.sikuli;

import com.asprise.ocr.Ocr;
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
    private static String PRICE_RANGE = "price_range";

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
            BufferedImage image = screen.capture(x,y,45,h).getImage();
            BufferedImage zoomImage = zoomInImage(image);
            saveImg(zoomImage);
            String priceRange = ocrPrice(url(PRICE_RANGE));
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
        File file = new File(url(PRICE_RANGE));
        try {
            ImageIO.write(image,"png",file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String ocrPrice(String imgName){
        Ocr.setUp();
        Ocr ocr = new Ocr();
        ocr.startEngine("eng",Ocr.SPEED_FASTEST);

        String s = ocr.recognize(new File[]{new File(url(PRICE_RANGE))},Ocr.RECOGNIZE_TYPE_ALL,Ocr.OUTPUT_FORMAT_PLAINTEXT);
        System.out.println(s);
        return s;
    }

    public static BufferedImage zoomInImage(BufferedImage originalImage)
    {
        Image image = originalImage.getScaledInstance(100,38,Image.SCALE_SMOOTH);
        BufferedImage bufferedImage = new BufferedImage(100,38,BufferedImage.TYPE_3BYTE_BGR);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.drawImage(image,0,0,null);
        return bufferedImage;
    }
}
