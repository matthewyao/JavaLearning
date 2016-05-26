package com.matthewyao.sikuli;

import com.asprise.ocr.Ocr;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by matthewyao on 2016/5/26.
 */
public class TestOCR {
    public static void execute(){
        Ocr.setUp();
        Ocr ocr = new Ocr();
        ocr.startEngine("eng",Ocr.SPEED_FASTEST);

//        String s1 = ocr.recognize(new File[]{new File("E:\\sikuli.image\\price_test.png")},Ocr.RECOGNIZE_TYPE_TEXT,Ocr.OUTPUT_FORMAT_PLAINTEXT);
        String s2 = ocr.recognize(new File[]{new File("E:\\sikuli.image\\price_range_1.png")},Ocr.RECOGNIZE_TYPE_TEXT,Ocr.OUTPUT_FORMAT_PLAINTEXT);
//        System.out.println(s1);
        System.out.println(s2);
    }
}
