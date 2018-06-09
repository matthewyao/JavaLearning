package com.matthewyao.designpattern.chain;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class DeptManager extends Leader {

    public DeptManager(Leader successor) {
        super(successor);
    }

    @Override
    public void handleRequest(Reimbursement reimbursement) {
        int money = reimbursement.getMoney();
        if (money <= 2000) {
            approve("Dept manager", reimbursement);
        }else {
            Leader successor = getSuccessor();
            successor.handleRequest(reimbursement);
        }
    }
}
