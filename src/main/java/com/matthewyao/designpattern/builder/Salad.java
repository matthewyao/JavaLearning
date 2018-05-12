package com.matthewyao.designpattern.builder;

/**
 * Created by yaokuan on 2018/5/12.
 */
public class Salad {

    private String vegetables;

    private String amaranth;

    private String sauce;

    public String getVegetables() {
        return vegetables;
    }

    public void setVegetables(String vegetables) {
        this.vegetables = vegetables;
    }

    public String getAmaranth() {
        return amaranth;
    }

    public void setAmaranth(String amaranth) {
        this.amaranth = amaranth;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    @Override
    public String toString() {
        return "Salad{" +
                "vegetables='" + vegetables + '\'' +
                ", amaranth='" + amaranth + '\'' +
                ", sauce='" + sauce + '\'' +
                '}';
    }
}
