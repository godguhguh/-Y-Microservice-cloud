package com.ypp.tunte.enums;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/5 0005
 */
public enum  SexEnum {
    MALE("男"),FEMALE("女"),UNKNOWN("未知");

    private String name;


    SexEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
