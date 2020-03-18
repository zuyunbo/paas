package com.whir.budget.entity;

import com.whir.budget.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


/**
 * 流程表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LcStageWorkflowInstance extends BaseEntity {

     private Long project;

     private String type;

     private Integer schemeId;

     private String status;

     private Integer stageId;

     private Integer stepId;

     private String returnStep;

     private String userId;

     private String securityScope;

     private Long departmentId;

     private YsPayment ysPayment;

}
