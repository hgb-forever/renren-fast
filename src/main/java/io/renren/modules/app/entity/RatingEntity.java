package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 甘正
 * @Date: 2020/11/6  19:25
 * @Version 1.0
 */
@Data
@TableName("Rating")
public class RatingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /*用户id*/
    @NotBlank(message="用户id不能为空")
    private Long userId;
    /*文章id*/
    @NotBlank(message="文章id不能为空")
    private Long titleId;
    /*评分分数*/
    private Double score;
    /*时间戳*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timeStamp;
}
