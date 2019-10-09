package cn.eleven.shardingjdbc.service.Impl;

import cn.eleven.shardingjdbc.entity.Code;
import cn.eleven.shardingjdbc.mapper.CodeMapper;
import cn.eleven.shardingjdbc.service.CodeService;
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
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements CodeService {
    @Override
    public boolean save(Code entity) {
        return super.save(entity);
    }

    @Override
    public List<Code> getCodeList() {
        return baseMapper.selectList(Wrappers.<Code>lambdaQuery());
    }

}
