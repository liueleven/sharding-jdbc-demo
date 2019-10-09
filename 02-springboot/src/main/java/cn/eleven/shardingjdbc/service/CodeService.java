package cn.eleven.shardingjdbc.service;

import cn.eleven.shardingjdbc.entity.Code;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @description: 一定要写注释啊
 * @date:        2019-10-09
 * @author:      十一
 */
public interface CodeService extends IService<Code> {

    @Override
    boolean save(Code entity);

    List<Code> getCodeList();
    boolean update(Code entity);

}
