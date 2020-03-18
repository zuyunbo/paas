package com.whir.budget.entity;

import com.whir.budget.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "YS_PROJECT")
public class YsProject extends BaseEntity {

    /**
     * 项目编号
     */
    @Column(name = "SN", length = 50)
    private String sn;
    /**
     * 项目名称
     */
    @Column(name = "NAME", length = 50)
    private String name;

    /**
     * 采购数量
     * */
    @Column(name = "num", length = 20)
    private Long num;


    /**
     * 拆分预算金额
     */
    @Column(name = "XM_MONEY")
    private Integer xmMoney;

    /**
     * 医院
     */
    @Column(name = "HOSPITAL", length = 50)
    private String hospital;
    /**
     * 采购金额
     */
    @Column(name = "PUR_MONEY")
    private Integer purMoney;

    /**
     * 计划招标准备日期
     */
    @Column(name = "PLANNED_ZB_TIME")
    private Date plannedZbTime;

    /**
     * 计划招标公示日期
     */
    @Column(name = "PLANNED_GS_TIME")
    private Date plannedGsTime;

    /**
     * 计划招标完成日期
     */
    @Column(name = "PLANNED_COMPLETE_TIME")
    private Date plannedCompleteTime;

    /**
     * 计划签订合同日期
     */
    @Column(name = "PLANNED_HT_TIME")
    private Date plannedHtTime;

    /**
     * 计划验收时间
     */
    @Column(name = "PLANNED_YS_TIME")
    private Date plannedYsTime;
    /**
     * 计划申请付款时间
     */
    @Column(name = "PLANNED_FK_TIME")
    private Date plannedFkTime;

    /**
     * 执行状态
     */
    @Column(name = "EXECUTIONSTATUS" ,length = 50)
    private  String executionStatus;


    /**
     * 付款列表
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private List<YsPayment> payments;

    /**
     * 招标完成金额
     */
    @Column(name = "ZB_MONEY" ,length = 50)
    private  Integer  zbmoney;

    /**
     * 合同金额
     */
    @Column(name = "CONTRACT_MONEY", length = 50)
    private Integer contractMoney;

    /**
     * 单位自筹金额
     */
    @Column(name = "SELF_MONEY", length = 50)
    private String selfMoney;

    /**
     * 阶段id
     */
    @Column(name = "STAGEID" )
    private  Long  stage;

    /**
     * 步骤id
     */
    @Column(name = "STEPID" )
    private  Long  step;

}
