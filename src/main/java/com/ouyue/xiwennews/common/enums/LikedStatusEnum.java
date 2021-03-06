package com.ouyue.xiwennews.common.enums;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum LikedStatusEnum {
    LIKE(1, "点赞"),
    UNLIKE(0, "取消点赞/未点赞"),
    ;
   public static  final Map<Integer,LikedStatusEnum> map =new HashMap<>();
    private Integer code;

    private String msg;

    LikedStatusEnum(Integer code, String msg) {
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
        for (LikedStatusEnum likedStatusEnum:LikedStatusEnum.values()){
            map.put(likedStatusEnum.getCode(),likedStatusEnum);
        }
    }
    public static LikedStatusEnum getCode(int code){
        return map.get(code);
    }
}
