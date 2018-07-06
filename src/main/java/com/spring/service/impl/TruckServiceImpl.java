package com.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.dao.TruckMapper;
import com.spring.dao.UserManagerDao;
import com.spring.domain.Companyinfo;
import com.spring.domain.Truck;
import com.spring.domain.UserInfo;
import com.spring.service.TruckService;
import com.spring.service.UserManagerService;
import com.spring.util.DataGrid;
@Service
public class TruckServiceImpl implements TruckService{
	@Autowired
	private TruckMapper truckmapper;

	@Override
	public void delete(Truck[] truckid) {
		truckmapper.delete(truckid);
	}

	@Override
	public int insert(Truck record) {
		// TODO Auto-generated method stub
		
		return truckmapper.insert(record);
	}

	@Override
	public DataGrid<Truck> selectByPrimaryKey(Truck truck,int currentPage, int pageCount) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageCount);
		List<Truck> companyList = truckmapper.selectByPrimaryKey(truck);
		PageInfo<Truck> pageInfo = new PageInfo<Truck>(companyList);
		DataGrid<Truck> dg = new DataGrid<Truck>();
		dg.setData(pageInfo.getList());
		dg.setCount(pageInfo.getTotal());
		dg.setPage(pageInfo.getPageNum());
		return dg;
	}

	@Override
	public int update(Truck record) {
		// TODO Auto-generated method stub
		return truckmapper.update(record);
	}
	
	

}
