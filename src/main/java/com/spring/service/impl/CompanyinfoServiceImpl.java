package com.spring.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.dao.CompanyinfoMapper;
import com.spring.dao.UserManagerDao;
import com.spring.domain.Companyinfo;
import com.spring.domain.UserInfo;
import com.spring.service.CompanyinfoService;
import com.spring.service.UserManagerService;
import com.spring.util.DataGrid;
@Service
public class CompanyinfoServiceImpl implements CompanyinfoService{
	@Autowired
	private CompanyinfoMapper companyinfomapper;

	/**
	 * 批量删除
	 */
	@Override
	public void deleteByPrimaryKey(Companyinfo[] companys) {
		companyinfomapper.deleteByPrimaryKey(companys);
	}

	@Override
	public int insert(Companyinfo record) {
		// TODO Auto-generated method stub
		return companyinfomapper.insert(record);
	}

	@Override
	public DataGrid<Companyinfo> selectByPrimaryKey(Companyinfo record,int currentPage, int pageCount) {
		// TODO Auto-generated method stub
		/**
		 * 分页模糊查询
		 */
		PageHelper.startPage(currentPage, pageCount);
		List<Companyinfo> companyList = companyinfomapper.selectByPrimaryKey(record);
		PageInfo<Companyinfo> pageInfo = new PageInfo<Companyinfo>(companyList);
		DataGrid<Companyinfo> dg = new DataGrid<Companyinfo>();
		dg.setData(pageInfo.getList());
		dg.setCount(pageInfo.getTotal());
		dg.setPage(pageInfo.getPageNum());
		return dg;
	}

	@Override
	public int updateByPrimaryKey(Companyinfo record) {
		// TODO Auto-generated method stub
		return companyinfomapper.updateByPrimaryKey(record);
	}
	
}
