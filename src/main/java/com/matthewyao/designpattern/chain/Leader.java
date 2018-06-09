package com.matthewyao.designpattern.chain;

/**
 * Created by yaokuan on 2018/6/2.
 */
public abstract class Leader {
    private Leader successor;

    public Leader(Leader successor) {
        this.successor = successor;
    }

    public Leader getSuccessor() {
        return successor;
    }

    public abstract void handleRequest(Reimbursement reimbursement);

    public void approve(String role, Reimbursement reimbursement) {
        System.out.println(String.format("%s has approved %s's reimbursement, money: $%s", role,
                reimbursement.getUsername(), reimbursement.getMoney()));
    }
}
