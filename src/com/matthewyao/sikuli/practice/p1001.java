package com.matthewyao.sikuli.practice; /**
 * Created by matthewyao on 2016/1/7.
 */

import java.math.BigDecimal;
import java.util.Scanner;

public class p1001
{
    public static void main(String args[]) throws Exception
    {
        BigDecimal[] rs = {new BigDecimal("95.123"),new BigDecimal("0.4321"),new BigDecimal("5.1234"),new BigDecimal("6.7592"),new BigDecimal("98.999"),new BigDecimal("1.0100")};
        int[] ns = {12,20,15,9,10,12};
        //TODO:read from keyboard
//        int[] ns = {2,2,2,2,2,2};
//        Scanner cin=new Scanner(System.in);
        for(int i=0;i<6;i++){
            BigDecimal r = rs[i],res = rs[i];
            int s = ns[i];
            for (int j=1;j<s;j++){
                res = res.multiply(r);
            }
            System.out.println(res);
//            double a=cin.nextDouble(),b=cin.nextInt();
//            System.out.println(a+b);
        }
    }
}
