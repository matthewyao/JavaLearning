package com.matthewyao.test;

import sun.misc.BASE64Decoder;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * Created by matthewyao on 2016/11/8.
 */
public class TestLongToInt {
    public static void main(String[] args) {
        try{
            throw new Throwable("throwable");
        }catch (Exception e){
            System.out.println("exception caught");
        }catch (Throwable t){
            System.out.println("throwable caught");
        }
    }
}
