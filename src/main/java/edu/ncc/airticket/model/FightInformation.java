package edu.ncc.airticket.model;

import lombok.Data;

@Data
public class FightInformation extends BaseModel{
    /*private int  fliAutoid;*/
    private String comCode;
    private String airCode;
    private String fliNo;
    private int fliDisCount;
    private String fliBaddress;
    private String fliAaddress;
    private String fliBtime;
    private  String fliAtime;
    private int fliFnumber;
    private int fliCnumber;
    private int fliYnumber;
    private int fliGfare;
    private int fliTfare;
    private int fliJfare;
    private String fliRefundtime;
  /*  private String flag;*/

}
