package com.whir.budget.dao;

import com.whir.budget.entity.YsPayment;
import com.whir.budget.entity.YsProject;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface YsProjectDao extends Mapper<YsProject> {
}
