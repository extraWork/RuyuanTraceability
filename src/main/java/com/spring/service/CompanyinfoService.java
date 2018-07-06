package com.spring.service;

import java.math.BigDecimal;
import java.util.List;

import com.spring.domain.Companyinfo;
import com.spring.domain.UserInfo;
import com.spring.util.DataGrid;

public interface CompanyinfoService {
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
    DataGrid<Companyinfo> selectByPrimaryKey(Companyinfo record,int currentPage, int pageCount);
    
    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(Companyinfo record);
}
