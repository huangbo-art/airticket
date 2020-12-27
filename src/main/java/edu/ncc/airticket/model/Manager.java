package edu.ncc.airticket.model;

import lombok.Data;

import java.util.Date;

@Data
public class Manager extends BaseModel{
    /*private int manAutoId;*/
    private  String manAccount;
    private  String manPwd;
    private String manId;
    private String manSex;
    private String manTelNumber;
    private String manEmail;
    private Date manTime;
    /*private String flag;*/    //0:管理员 1:删除


}
