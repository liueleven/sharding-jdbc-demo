package cn.eleven.shardingjdbc.service.Impl;

import cn.eleven.shardingjdbc.entity.Address;
import cn.eleven.shardingjdbc.mapper.AddressMapper;
import cn.eleven.shardingjdbc.service.AddressService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
    @Override
    public boolean save(Address entity) {
        return super.save(entity);
    }

    @Override
    public List<Address> getAddressList() {
        return baseMapper.selectList(Wrappers.<Address>lambdaQuery());
    }

}
