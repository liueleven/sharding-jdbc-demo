package cn.eleven.shardingjdbc.service.Impl;

import cn.eleven.shardingjdbc.entity.User;
import cn.eleven.shardingjdbc.mapper.UserMapper;
import cn.eleven.shardingjdbc.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 一定要写注释啊
 * @date:        2019-10-09
 * @author:      十一
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public boolean save(User entity) {
        return super.save(entity);
    }

    @Override
    public List<User> getUserList() {
        return baseMapper.selectList(Wrappers.<User>lambdaQuery().orderByAsc(User::getUid));
    }

}
