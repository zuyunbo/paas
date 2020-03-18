package com.whir.budget.resolver;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.whir.budget.dao.LcStageWorkflowInstanceDao;
import com.whir.budget.entity.LcStageWorkflowInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Component
public class StageGraphQLQueryResolver implements GraphQLQueryResolver {

    @Autowired
    LcStageWorkflowInstanceDao lcStageWorkflowInstanceDao;

    public List<LcStageWorkflowInstance> stageWorkflowInstanceAll(int page, int pageSize){
        LcStageWorkflowInstance query = new LcStageWorkflowInstance();
        query.setType("fk");
        Example lcStageWorkflowInstancesExample = new Example(LcStageWorkflowInstance.class);
        lcStageWorkflowInstancesExample.createCriteria().andEqualTo("type","fk");
        List<LcStageWorkflowInstance> lcStageWorkflowInstances = lcStageWorkflowInstanceDao.selectByExample(lcStageWorkflowInstancesExample);
        return   lcStageWorkflowInstances;
    }

}
