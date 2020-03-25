package com.whir.budget.result;

import com.github.pagehelper.PageInfo;
import com.whir.budget.entity.LcStageWorkflowInstance;
import lombok.Data;

import java.util.List;

@Data
public class StageWorkflowInstanceCon {

    private Long totalCount;
    private Integer pageSize;
    private Integer totalPage;
    private Integer currentPage;
    private List<LcStageWorkflowInstance> edges;


}
