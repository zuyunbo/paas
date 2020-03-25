package com.whir.budget.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.whir.budget.dao.YsProjectDao;
import com.whir.budget.entity.YsPayment;
import com.whir.budget.entity.YsProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class YsPaymentGraphQLResolver implements GraphQLResolver<YsPayment> {

    @Autowired
    private YsProjectDao ysProjectDao;


    public YsProject returnProject(YsPayment ysPayment) {
        return ysProjectDao.selectByPrimaryKey(ysPayment.getProId());
    }


}
