package cn.stylefeng.guns.modular.kangyuan.mapper;

import cn.stylefeng.guns.core.common.node.TreeviewNode;
import cn.stylefeng.guns.core.common.node.ZTreeNode;
import cn.stylefeng.guns.modular.kangyuan.entity.Gydb;
import cn.stylefeng.guns.modular.system.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
public interface GydbMapper extends BaseMapper<Gydb> {


    Page<Map<String, Object>> list(@Param("page") Page page);



}
