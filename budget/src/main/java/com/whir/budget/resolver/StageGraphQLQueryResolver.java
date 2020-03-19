package com.whir.budget.resolver;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whir.budget.dao.LcStageWorkflowInstanceDao;
import com.whir.budget.entity.LcStageWorkflowInstance;
import com.whir.budget.result.StageWorkflowInstanceCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Component
public class StageGraphQLQueryResolver implements GraphQLQueryResolver {

    @Autowired
    LcStageWorkflowInstanceDao lcStageWorkflowInstanceDao;

    public StageWorkflowInstanceCon stageWorkflowInstanceAll(int page, int pageSize){
        StageWorkflowInstanceCon con = new StageWorkflowInstanceCon();
        LcStageWorkflowInstance query = new LcStageWorkflowInstance();
        query.setType("fk");
        Example lcStageWorkflowInstancesExample = new Example(LcStageWorkflowInstance.class);
        lcStageWorkflowInstancesExample.createCriteria().andEqualTo("type","fk");
        PageHelper.startPage(page, pageSize);
        List<LcStageWorkflowInstance> lcStageWorkflowInstances = lcStageWorkflowInstanceDao.selectByExample(lcStageWorkflowInstancesExample);
        PageInfo<LcStageWorkflowInstance> lcStageWorkflowInstancePageInfo = new PageInfo<>(lcStageWorkflowInstances);
        con.setTotalCount(lcStageWorkflowInstancePageInfo.getTotal());
        con.setTotalPage(lcStageWorkflowInstancePageInfo.getPages());
        con.setPageSize(lcStageWorkflowInstancePageInfo.getPageSize());
        con.setCurrentPage(page);
        con.setEdges(lcStageWorkflowInstancePageInfo.getList());
        return  con;
    }

}
