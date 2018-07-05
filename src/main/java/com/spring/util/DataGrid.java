package com.spring.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * 前台显示类
 *
 * @param <T>
 */
public class DataGrid<T>  implements Serializable{
	private static final long serialVersionUID = -1375329857025959679L;
	
	private long count; //总数
	private List<T> data;  //数据
	private Integer page; //当前页
	                    //前三项用于layui.page
						//layui的数据表格的分页还需要后面2项
	private String msg;   
	private String code = "0";  //layui默认0为正常
	
	private Map<String, Object> otherResult ; //除表格外 页面所需的其他信息
	
	public Map<String, Object> getOtherResult() {
		return otherResult;
	}
	public void setOtherResult(Map<String, Object> otherResult) {
		this.otherResult = otherResult;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
