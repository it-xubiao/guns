package cn.stylefeng.guns.modular.kangyuan.service;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.modular.kangyuan.entity.Gydb;
import cn.stylefeng.guns.modular.kangyuan.mapper.GydbMapper;
import cn.stylefeng.guns.modular.system.mapper.RelationMapper;
import cn.stylefeng.guns.modular.system.mapper.RoleMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName gydbService
 * @Description TODO
 * @Author xubiao
 * @Date 2019/6/2817:18
 **/
@Service
public class gydbService extends ServiceImpl<GydbMapper, Gydb> {

    @Resource
    private GydbMapper gydbMapper;


    /**
     * 分页查询
     * @param condition
     * @return
     */
    public Page<Map<String, Object>> selectRoles(String condition) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.list(page);
    }
}
