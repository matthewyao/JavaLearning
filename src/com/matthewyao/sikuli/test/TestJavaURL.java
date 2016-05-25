package com.matthewyao.sikuli.test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by matthewyao on 2016/1/29.
 */
public class TestJavaURL {
    public static void curl(String addr){
        try {
            URL url = new URL(addr);
            String line = "";
            FileOutputStream fo = new FileOutputStream(new File("D:/Baidu.html"));
            BufferedOutputStream oBuffer = new BufferedOutputStream(fo);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
            while ((line = reader.readLine()) != null){
                System.out.println(line);
                line += "\n";
                oBuffer.write(line.getBytes());
            }
            oBuffer.flush();
            oBuffer.close();
        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
