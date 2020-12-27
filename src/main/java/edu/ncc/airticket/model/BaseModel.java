package edu.ncc.airticket.model;

import lombok.Data;

@Data
public class BaseModel {
    protected Integer id;
    protected String flag;

    public static final String NORMAL="0";
    public static final String DELETE="1";
    public static final String FOO="2";
    public static final String BAR="3";
}
