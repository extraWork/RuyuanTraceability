package com.spring.domain;

/**
 * 菜单pojo类
 * @author Fantasyo
 *
 */
public class ModuleInfo {
	private int moduleId;
	private String moduleName;
	private String moduleParent;
	private String moduleURL;
	private String moduleNo;
	private String moduleType;
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleParent() {
		return moduleParent;
	}
	public void setModuleParent(String moduleParent) {
		this.moduleParent = moduleParent;
	}
	public String getModuleURL() {
		return moduleURL;
	}
	public void setModuleURL(String moduleURL) {
		this.moduleURL = moduleURL;
	}
	public String getModuleNo() {
		return moduleNo;
	}
	public void setModuleNo(String moduleNo) {
		this.moduleNo = moduleNo;
	}
	public String getModuleType() {
		return moduleType;
	}
	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}
	
}
