package com.whir.budget.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.whir.budget.dao.OrgDepartmentDao;
import com.whir.budget.dao.YsProjectDao;
import com.whir.budget.entity.OrgDepartment;
import com.whir.budget.entity.YsBudget;
import com.whir.budget.entity.YsPayment;
import com.whir.budget.entity.YsProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class YsBudgetGraphQLResolver implements GraphQLResolver<YsBudget> {

    @Autowired
    private OrgDepartmentDao orgDepartmentDao;


    public OrgDepartment returnDepartment(YsBudget ysPayment) {
        return orgDepartmentDao.selectByPrimaryKey(Long.valueOf(ysPayment.getHospital()));
    }


}
