package cn.eleven.shardingjdbc.mapper;


import cn.eleven.shardingjdbc.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @date: 2019-10-09 16:08
 * @author: 十一
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
