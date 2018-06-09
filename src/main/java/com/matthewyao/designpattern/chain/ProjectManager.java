package com.matthewyao.designpattern.chain;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class ProjectManager extends Leader {

    public ProjectManager(Leader successor) {
        super(successor);
    }

    @Override
    public void handleRequest(Reimbursement reimbursement) {
        int money = reimbursement.getMoney();
        if (money <= 500) {
            approve("Project manager", reimbursement);
        }else {
            Leader successor = getSuccessor();
            successor.handleRequest(reimbursement);
        }
    }
}
