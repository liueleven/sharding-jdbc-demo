package cn.eleven.shardingjdbc.service;

import cn.eleven.shardingjdbc.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @description: 一定要写注释啊
 * @date:        2019-10-09
 * @author:      十一
 */
public interface UserService extends IService<User> {

    /**
     * 保存用户信息
     * @param entity
     * @return
     */
    @Override
    boolean save(User entity);

    /**
     * 查询全部用户信息
     * @return
     */
    List<User> getUserList();
}
