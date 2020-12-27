package edu.ncc.airticket.model;
import lombok.Data;

@Data
public class AirType extends BaseModel {
    private String airCode;
    private String airFNumber;
    private String airCNumber;
    private String airYNumber;
    private String airTotalNumber;
}
