package com.whir.budget.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.whir.budget.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author penghanying
 * @ClassName: DevelopStep
 * @Description: (这里用一句话描述这个类的作用)
 * @date 2019/5/7
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LC_STAGE_WORKFLOW_STEP")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class LcStageWorkflowStep extends BaseEntity {


    /**名称
     *
     */
    @Column(name = "NAME",length = 50)
    private String name;

    /**介绍
     *
     */
    @Column(name = "DESCRIPTION",length = 255)
    private String description;


}
