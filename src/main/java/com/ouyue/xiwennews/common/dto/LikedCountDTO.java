package com.ouyue.xiwennews.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-21 16-15
 */

@Data
@ToString
@AllArgsConstructor
public class LikedCountDTO {
    String key;

    Integer value;
}
