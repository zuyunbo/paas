package com.whir.budget.entity;


import com.whir.budget.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

/**
 * @author limaofeng
 * @version V1.0
 * @Description: 部门
 * @date 2019-03-11 14:35
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrgDepartment extends BaseEntity  {

    /**
     * 简写
     */
    @Column(name = "sn", length = 10)
    private String sn;
    /**
     * 名称
     */
    @Column(name = "NAME", length = 50)
    private String name;
    /**
     * 路径
     */
    @Column(name = "PATH", length = 50)
    private String path;
    /**
     * 排序字段
     */
    @Column(name = "SORT")
    private Integer sort;
    /**
     * 描述信息
     */
    @Column(name = "DESCRIPTION", length = 150)
    private String description;
    /**
     * 是否启用 0禁用 1 启用
     */
    @Column(name = "ENABLED")
    private Boolean enabled;
}