package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spring.domain.Book;
import com.spring.domain.City;
import com.spring.service.CityService;

/**
 * Created by bysocket on 07/02/2017.
 */
@Controller(value="city")
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    @ResponseBody
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }
    
    @RequestMapping(value = "/index")
    public String index1( String cityName) {
        return "index";
    }
    @RequestMapping(value = "/user")
    public String user( String cityName) {
    	return "SystemManager/user";
    }
    @RequestMapping(value = "/systemModule")
    public String systemModule( String cityName) {
    	return "SystemManager/systemModule";
    }
    @RequestMapping(value = "/testtiao")
    public String testtiao( String cityName) {
    	return "SystemManager/test";
    }
    @RequestMapping(value = "/test")
    @ResponseBody
    public String test( String cityName) {
    	String s = "{\"rows\":[{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"辖区管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"orgManager\",\"_PARENTID\":1953,\"_parentId\":1953,\"id\":1954,\"parentId\":1953,\"name\":\"辖区管理\",\"ID\":1954,\"appshortname\":\"ICarefxPMS\",\"PARENTID\":1953,\"resourceTypeCode\":\"FrameworkMenu\",\"CODE\":\"orgManager\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"用户权限管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"userRoleMge\",\"id\":1945,\"name\":\"用户权限管理\",\"ID\":1945,\"appshortname\":\"ICarefxPMS\",\"CODE\":\"userRoleMge\",\"resourceTypeCode\":\"FrameworkMenu\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"机构管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"deptMge\",\"_PARENTID\":1953,\"_parentId\":1953,\"id\":1997,\"parentId\":1953,\"name\":\"机构管理\",\"ID\":1997,\"appshortname\":\"ICarefxPMS\",\"PARENTID\":1953,\"resourceTypeCode\":\"FrameworkMenu\",\"CODE\":\"deptMge\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"用户管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"userMge\",\"_PARENTID\":1945,\"_parentId\":1945,\"id\":1946,\"parentId\":1945,\"name\":\"用户管理\",\"ID\":1946,\"appshortname\":\"ICarefxPMS\",\"PARENTID\":1945,\"resourceTypeCode\":\"FrameworkMenu\",\"CODE\":\"userMge\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"角色管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"roleMge\",\"_PARENTID\":1945,\"_parentId\":1945,\"id\":1947,\"parentId\":1945,\"name\":\"角色管理\",\"ID\":1947,\"appshortname\":\"ICarefxPMS\",\"PARENTID\":1945,\"resourceTypeCode\":\"FrameworkMenu\",\"CODE\":\"roleMge\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"用户辖区管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"userOrgMge\",\"_PARENTID\":1945,\"_parentId\":1945,\"id\":1948,\"parentId\":1945,\"name\":\"用户辖区管理\",\"ID\":1948,\"appshortname\":\"ICarefxPMS\",\"PARENTID\":1945,\"resourceTypeCode\":\"FrameworkMenu\",\"CODE\":\"userOrgMge\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"系统资源管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"sysResMge\",\"id\":1949,\"name\":\"系统资源管理\",\"ID\":1949,\"appshortname\":\"ICarefxPMS\",\"CODE\":\"sysResMge\",\"resourceTypeCode\":\"FrameworkMenu\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"应用系统管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"applicationSystemManagement\",\"_PARENTID\":1949,\"_parentId\":1949,\"id\":1950,\"parentId\":1949,\"name\":\"应用系统管理\",\"ID\":1950,\"appshortname\":\"ICarefxPMS\",\"PARENTID\":1949,\"resourceTypeCode\":\"FrameworkMenu\",\"CODE\":\"applicationSystemManagement\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"资源类型管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"managementOfTheResourceType\",\"_PARENTID\":1949,\"_parentId\":1949,\"id\":1951,\"parentId\":1949,\"name\":\"资源类型管理\",\"ID\":1951,\"appshortname\":\"ICarefxPMS\",\"PARENTID\":1949,\"resourceTypeCode\":\"FrameworkMenu\",\"CODE\":\"managementOfTheResourceType\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"资源管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"resourceManagement\",\"_PARENTID\":1949,\"_parentId\":1949,\"id\":1952,\"parentId\":1949,\"name\":\"资源管理\",\"ID\":1952,\"appshortname\":\"ICarefxPMS\",\"PARENTID\":1949,\"resourceTypeCode\":\"FrameworkMenu\",\"CODE\":\"resourceManagement\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"机构类型管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"orgTypeManager\",\"_PARENTID\":1953,\"_parentId\":1953,\"id\":1955,\"parentId\":1953,\"name\":\"机构类型管理\",\"ID\":1955,\"appshortname\":\"ICarefxPMS\",\"PARENTID\":1953,\"resourceTypeCode\":\"FrameworkMenu\",\"CODE\":\"orgTypeManager\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"行政机构管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"orgUnionMge\",\"id\":1953,\"name\":\"行政机构管理\",\"ID\":1953,\"appshortname\":\"ICarefxPMS\",\"CODE\":\"orgUnionMge\",\"resourceTypeCode\":\"FrameworkMenu\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"组织管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"unionManager\",\"_PARENTID\":1953,\"_parentId\":1953,\"id\":1956,\"parentId\":1953,\"name\":\"组织管理\",\"ID\":1956,\"appshortname\":\"ICarefxPMS\",\"PARENTID\":1953,\"resourceTypeCode\":\"FrameworkMenu\",\"CODE\":\"unionManager\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"字典管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"dictMge\",\"id\":2055,\"name\":\"字典管理\",\"ID\":2055,\"appshortname\":\"ICarefxPMS\",\"CODE\":\"dictMge\",\"resourceTypeCode\":\"FrameworkMenu\"},{\"RESOURCETYPECODE\":\"FrameworkMenu\",\"STATE\":\"closed\",\"appId\":1161,\"NAME\":\"字典管理\",\"state\":\"closed\",\"APPSHORTNAME\":\"ICarefxPMS\",\"APPID\":1161,\"code\":\"dictMgr\",\"_PARENTID\":2055,\"_parentId\":2055,\"id\":2056,\"parentId\":2055,\"name\":\"字典管理\",\"ID\":2056,\"appshortname\":\"ICarefxPMS\",\"PARENTID\":2055,\"resourceTypeCode\":\"FrameworkMenu\",\"CODE\":\"dictMgr\"}]}";
    	return s;
    }

    @RequestMapping(value = "/api/queryAll", method = RequestMethod.GET)
    public List<Book> queryAll(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.queryBookAll();
    }
}
