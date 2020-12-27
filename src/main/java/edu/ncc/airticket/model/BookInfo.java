package edu.ncc.airticket.model;

import edu.ncc.airticket.dao.BaseDao;
import lombok.Data;

import java.util.Date;

@Data
public class BookInfo extends BaseModel {
    //private int booAutoId;
    private String comCode;
    private String cusId;
    private String booNo;
    private String boobAddress;
    private String booaAddress;
    private Date boobTime;
    private Date booaTime;
    private String booBerth;
    private String booNumber;
    private Double booFare;
    private Date booTime;
    private Boolean flagPay;
    //private String flag;
    //0:待审核；1：审核通过；2：退票待审核；3：退票成功
}
