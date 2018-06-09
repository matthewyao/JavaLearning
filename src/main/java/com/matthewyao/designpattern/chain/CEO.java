package com.matthewyao.designpattern.chain;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class CEO extends Leader{

    public CEO() {
        //CEO没有上级！
        super(null);
    }

    @Override
    public void handleRequest(Reimbursement reimbursement) {
        int money = reimbursement.getMoney();
        if (money > 10000) {
            //只有婷婷可以报销1万元以上，其他人想都别想，你懂的~
            if (reimbursement.getUsername().equals("tingting")) {
                approve("CEO", reimbursement);
            }else {
                System.out.println(String.format("CEO has rejected %s's reimbursement, money: $%s",
                        reimbursement.getUsername(), reimbursement.getMoney()));
            }
        }
    }
}
