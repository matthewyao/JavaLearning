package com.matthewyao.designpattern.chain;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class CTO extends Leader {
    public CTO(Leader successor) {
        super(successor);
    }

    @Override
    public void handleRequest(Reimbursement reimbursement) {
        int money = reimbursement.getMoney();
        if (money <= 10000) {
            approve("CTO", reimbursement);
        }else {
            Leader successor = getSuccessor();
            successor.handleRequest(reimbursement);
        }
    }
}
