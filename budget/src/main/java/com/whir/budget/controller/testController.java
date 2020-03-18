package com.whir.budget.controller;


import com.whir.budget.dao.LcStageWorkflowInstanceDao;
import com.whir.budget.dao.YsPaymentDao;
import com.whir.budget.entity.LcStageWorkflowInstance;
import com.whir.budget.entity.YsPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    LcStageWorkflowInstanceDao lcStageWorkflowInstanceDao;

    @Autowired
    YsPaymentDao ysPaymentDao;

    @GetMapping(value = "/list")
    public Object list() {

        LcStageWorkflowInstance query = new LcStageWorkflowInstance();
        query.setType("fk");
        Example lcStageWorkflowInstancesExample = new Example(LcStageWorkflowInstance.class);
        lcStageWorkflowInstancesExample.createCriteria().andEqualTo("type","fk");
        List<LcStageWorkflowInstance> lcStageWorkflowInstances = lcStageWorkflowInstanceDao.selectByExample(lcStageWorkflowInstancesExample);

        // 增加付款
        lcStageWorkflowInstances.forEach(lcStageWorkflowInstance -> {
            lcStageWorkflowInstance.setYsPayment(ysPaymentDao.selectByPrimaryKey(lcStageWorkflowInstance.getProject()));
        });


        return lcStageWorkflowInstances;
    }

    @PostMapping(value = "/list1")
    public Object lis1t() {

        LcStageWorkflowInstance query = new LcStageWorkflowInstance();
        query.setType("fk");
        Example lcStageWorkflowInstancesExample = new Example(LcStageWorkflowInstance.class);
        lcStageWorkflowInstancesExample.createCriteria().andEqualTo("type","fk");
        List<LcStageWorkflowInstance> lcStageWorkflowInstances = lcStageWorkflowInstanceDao.selectByExample(lcStageWorkflowInstancesExample);

        // 增加付款
        lcStageWorkflowInstances.forEach(lcStageWorkflowInstance -> {
            lcStageWorkflowInstance.setYsPayment(ysPaymentDao.selectByPrimaryKey(lcStageWorkflowInstance.getProject()));
        });


        return lcStageWorkflowInstances;
    }

}
