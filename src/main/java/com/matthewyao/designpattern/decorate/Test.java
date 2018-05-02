package com.matthewyao.designpattern.decorate;

/**
 * Created by yaokuan on 2018/5/1.
 */
public class Test {

    public static void main(String[] args) {
        Salad salad = new FishDecorator(new EggDecorator(new FruitSalad()));
        print(salad);

        Salad salad1 = new FishDecorator(new EggDecorator(new ScaleDecorator(new FruitSalad().setScale(3))));
        print(salad1);

        Salad salad2 = new AppleDecorator(new EggDecorator(new FishDecorator(new AppleDecorator(new EggDecorator(new CaesarSalad())))));
        print(salad2);

        Salad salad3 = new CobbSalad();
        print(salad3);

        Salad salad4 = new EggDecorator(new EggDecorator(new FruitSalad()));
        print(salad4);
    }

    private static void print(Salad salad) {
        System.out.println(salad.getName() +" 总计: " + salad.getPrice() + "元");
    }
}
