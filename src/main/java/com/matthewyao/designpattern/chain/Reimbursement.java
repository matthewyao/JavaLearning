package com.matthewyao.designpattern.chain;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class Reimbursement {
    //Reimbursement: 报销单
    private String username;
    private int money;

    public Reimbursement(String username, int money) {
        this.username = username;
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public int getMoney() {
        return money;
    }
}
