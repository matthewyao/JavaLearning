package com.matthewyao.test;

/**
 * Created by matthewyao on 2016/4/19.
 */
public class TestFinalKeyWord {
    /** Final类型变量必须手动初始化
     * 所有构造函数都必须初始化final变量
     * static final变量必须在声明时初始化
    */
    private final String str;

    public static void main(String[] args) {

    }

    public TestFinalKeyWord(String str, int i){
        this.str = str;
    }

    public TestFinalKeyWord(String str){
        this.str = str;
//        this();
    }

}
