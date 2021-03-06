package cn.eleven.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @description: 一定要写注释啊
 * @date: 2019-10-09 12:47
 * @author: 十一
 */
@Data
@EqualsAndHashCode
@Accessors
@TableName("code")
public class Code extends Model<Code> {

    private Long id;

    private String name;


}


