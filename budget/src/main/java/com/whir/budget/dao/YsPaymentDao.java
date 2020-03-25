package com.whir.budget.dao;

import com.whir.budget.entity.YsPayment;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface YsPaymentDao extends Mapper<YsPayment> {
}
