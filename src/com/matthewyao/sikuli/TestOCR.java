package com.matthewyao.sikuli;

import com.asprise.ocr.Ocr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by matthewyao on 2016/5/26.
 */
public class TestOCR {
    public static void execute(){
        Ocr.setUp();
        Ocr ocr = new Ocr();
        ocr.startEngine("eng",Ocr.SPEED_SLOW);

//        String s1 = ocr.recognize(new File[]{new File("E:\\sikuli.image\\price_test.png")},Ocr.RECOGNIZE_TYPE_TEXT,Ocr.OUTPUT_FORMAT_PLAINTEXT);
        BufferedImage image = null;
        try {
//            image = ImageIO.read(new FileInputStream("E:\\sikuli.image\\price_range0526055036.png"));
            image = ImageIO.read(new FileInputStream("E:\\sikuli.image\\price_range0526055036.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String s2 = ocr.recognize(new File[]{new File("E:\\sikuli.image\\price_range0526055036.png")},Ocr.RECOGNIZE_TYPE_TEXT,Ocr.OUTPUT_FORMAT_PLAINTEXT);
        String s2 = ocr.recognize(image,Ocr.RECOGNIZE_TYPE_TEXT,Ocr.OUTPUT_FORMAT_PLAINTEXT);

//        System.out.println(s1);
        System.out.println(s2);
        ocr.stopEngine();
    }
}
