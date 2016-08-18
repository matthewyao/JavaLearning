package com.matthewyao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by matthewyao on 2016/8/9.
 */
public class TimeTest {
    public static void execute() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        long s = (format.parse("05:02:15").getTime() - format.parse("00:00:00").getTime())/1000;
        System.out.println(s+" secodes");
    }
}
