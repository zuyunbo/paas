package com.whir.budget.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class BaseEntity {

    private static final long serialVersionUID = 4188086172919649925L;


    @Id
    @Column(insertable = false, updatable = false)   // 在插入数据库和修改数据库时 id字段不做操作
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建人
     */
    @Column(updatable = false, name = "CREATOR", length = 20)
    private String creator;
    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, name = "CREATE_TIME")
    private Date createdAt;
    /**
     * 最后修改人
     */
    @Column(name = "MODIFIER", length = 20)
    private String modifier;
    /**
     * 最后修改时间
     */
    @JsonProperty("modify_time")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_TIME")
    private Date updatedAt;

}
