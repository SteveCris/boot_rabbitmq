package com.ouyue.xiwennews.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum LikeTypeEnum {

    DEFAULT(0,"默认值"),

    LIKE_CASE(1,"点赞案例");

    public static  final Map<Integer,LikeTypeEnum> map =new HashMap<>();
    private Integer code;

    private String msg;

    LikeTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    static {
        for (LikeTypeEnum likedStatusEnum:LikeTypeEnum.values()){
            map.put(likedStatusEnum.getCode(),likedStatusEnum);
        }
    }
    public static LikeTypeEnum getCode(int code){
        return map.get(code);
    }
}
