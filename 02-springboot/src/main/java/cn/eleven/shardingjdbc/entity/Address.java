package cn.eleven.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import groovy.transform.EqualsAndHashCode;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: 一定要写注释啊
 * @date: 2019-10-09 12:47
 * @author: 十一
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("address")
public class Address extends Model<Address> {

    /**
     * 主键Id
     */
    private int aid;

    /**
     * 名称
     */
    private String name;

    /**
     * 用户id
     */
    private int uid;
}
