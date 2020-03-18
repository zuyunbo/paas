package com.whir.budget.entity;

import com.whir.budget.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

/**
 * @Author: fengmeng
 * @Date: 2019/3/29 15:17
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "YS_PAYMENT")
public class YsPayment extends BaseEntity {


    /**
     * 付款金额
     */
    @Column(name = "FK_MONEY")
    private Integer fkMoney;

    /**
     * 付款备注
     */
    @Column(name = "REMARKS")
    private String remarks;

    /**
     * 付款开始时间
     */
    @Column(name = "START_TIME")
    private Date startTime;

    /**
     * 审批完成时间
     */
    @Column(name = "END_TIME")
    private Date endTime;

    /**
     * 流程状态0.未提交 1.(审核完成-为付款) 2.(审核完成-付款完成)
     */
    @Column(name = "STATUS", length = 25)
    private String status ;


    /**
     * OA流程workId
     */
    @Column(name = "WORK_ID", length = 25)
    private Long workId;

    /**
     * OA流程节点
     */
    @Column(name = "WORK_CUR_STEP", length = 50)
    private String workCurStep;

    /**
     * 申请人
     */
    @Column(name = "USER_ID", length = 25)
    private String userId;

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


    @Column(name = "INS_ID")
    private Long StageWorkflowInstance;

    /**
     * 审批步骤名称
     */
    @Column(name = "STEP_NAME")
    private String stepName;

}
