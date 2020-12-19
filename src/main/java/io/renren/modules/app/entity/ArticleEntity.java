package io.renren.modules.app.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.annotations.Options;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_article")
public class ArticleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
    文章id
     */
    @TableId(type = IdType.AUTO)
    private Long articleId;

    /*
    * 用户id
    * */
    @NotBlank(message="用户id不能为空")
    private Long userId;

    /*
    文章标题
     */
    private String articleTitle;
    /*
    文章内容
    */
    private String articleContent;

    /*
    * 创建时间
    * */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
