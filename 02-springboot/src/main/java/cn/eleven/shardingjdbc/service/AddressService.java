package cn.eleven.shardingjdbc.service;


import cn.eleven.shardingjdbc.entity.Address;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @description:
 * @date:        2019-10-09
 * @author:      十一
 */
public interface AddressService extends IService<Address> {


    @Override
    boolean save(Address entity);


    List<Address> getAddressList();
}
