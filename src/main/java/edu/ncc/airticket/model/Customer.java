package edu.ncc.airticket.model;

import lombok.Data;

import java.util.Date;

@Data
public class Customer extends BaseModel {
    //private int cusAutoId;
    private String cusAccount;
    private String cusPwd;
    private String cusId;
    private String cusSex;
    private String cusTelNumber;
    private String cusEmail;
    private Date cusTime;
    private int cusIntegral;
    private Double farId;
    //private String flag;    //0:管理员；1：删除
}
