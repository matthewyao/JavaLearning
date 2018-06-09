package com.matthewyao.designpattern.chain;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class Client {
    public static void main(String[] args) {
        //首先构造责任链
        CEO ceo = new CEO();
        CTO cto = new CTO(ceo);
        DeptManager deptManager = new DeptManager(cto);
        ProjectManager projectManager = new ProjectManager(deptManager);

        Reimbursement zhangsan380 = new Reimbursement("zhangsan", 380);
        projectManager.handleRequest(zhangsan380);

        Reimbursement lishi1220 = new Reimbursement("lishi", 1220);
        projectManager.handleRequest(lishi1220);

        Reimbursement wangwu4400 = new Reimbursement("wangwu", 4400);
        projectManager.handleRequest(wangwu4400);

        Reimbursement zhangsan8880 = new Reimbursement("zhangsan", 8880);
        projectManager.handleRequest(zhangsan8880);

        Reimbursement lishi14900 = new Reimbursement("lishi", 14900);
        projectManager.handleRequest(lishi14900);

        Reimbursement tingting88888 = new Reimbursement("tingting", 88888);
        projectManager.handleRequest(tingting88888);
    }
}
