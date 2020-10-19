package com.chengf.transaction.singledb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chengf.transaction.singledb.domain.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chengaofeng
 * @date 2020年10月12日 上午11:56
 */
@Mapper
public interface DepartMentMapper extends BaseMapper<Department> {
}
