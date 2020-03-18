package com.whir.budget.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.whir.budget.dao.LcStageWorkflowStepDao;
import com.whir.budget.dao.YsPaymentDao;
import com.whir.budget.entity.LcStageWorkflowInstance;
import com.whir.budget.entity.LcStageWorkflowStep;
import com.whir.budget.entity.YsPayment;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StageWorkflowInstanceGraphQLResolver implements GraphQLResolver<LcStageWorkflowInstance> {

    @Autowired
    private YsPaymentDao ysPaymentDao;

    @Autowired
    private LcStageWorkflowStepDao lcStageWorkflowStepDao;



    public YsPayment returnPayments(LcStageWorkflowInstance instance) {
        /**根据当前步骤的id、流程方案的id，查询可以回退的步骤*/
        return ysPaymentDao.selectByPrimaryKey(instance.getProject());
    }


    public LcStageWorkflowStep stageWorkflowSteps(LcStageWorkflowInstance lcStageWorkflowInstance){
        return lcStageWorkflowStepDao.selectByPrimaryKey(lcStageWorkflowInstance.getStepId());
    }





}
