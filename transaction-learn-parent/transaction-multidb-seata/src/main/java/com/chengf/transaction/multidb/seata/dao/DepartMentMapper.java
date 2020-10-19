package com.chengf.transaction.multidb.seata.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chengf.transaction.multidb.seata.domain.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chengaofeng
 * @date 2020年10月12日 上午11:56
 */
@Mapper
@DS("mysql_chengf3306")
public interface DepartMentMapper extends BaseMapper<Department> {
}
