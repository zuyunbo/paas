package com.whir.budget.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.whir.budget.dao.YsBudgetDao;
import com.whir.budget.dao.YsProjectDao;
import com.whir.budget.entity.YsBudget;
import com.whir.budget.entity.YsPayment;
import com.whir.budget.entity.YsProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class YsProjectGraphQLResolver implements GraphQLResolver<YsProject> {

    @Autowired
    private YsBudgetDao ysBudgetDao;

    public YsBudget returnBudget(YsProject ysProject) {
        return ysBudgetDao.selectByPrimaryKey(ysProject.getYsId());
    }

}
