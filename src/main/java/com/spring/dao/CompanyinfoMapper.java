package com.spring.dao;

import com.spring.domain.Companyinfo;
import java.math.BigDecimal;
import java.util.List;

public interface CompanyinfoMapper {
    /**
     * 删除
     * @param companyid
     * @return
     */
    void deleteByPrimaryKey(Companyinfo[] companys);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(Companyinfo record);

    /**
     * 模糊查询
     * @param companyid
     * @return
     */
    List<Companyinfo> selectByPrimaryKey(Companyinfo record);
    
    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(Companyinfo record);
}