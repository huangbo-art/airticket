package edu.ncc.airticket.sys;

import edu.ncc.airticket.model.BaseModel;
import lombok.Data;

@Data
public class DTO<T extends BaseModel> {
    private T condition;
    private Integer pageNum;
    private Integer pageSize;
}
