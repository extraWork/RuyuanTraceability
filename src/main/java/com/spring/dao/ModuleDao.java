package com.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.domain.ModuleInfo;

/**
 * 菜单dao
 * @author Fantasyo
 *
 */
public interface ModuleDao {
	@Select({"<script>"
		,"select * from SYS_MODULE WHERE 1=1 "
				+ "<when test='moduleParent!=null'>and moduleParent=#{moduleParent}</when> "
				+ "<when test='isParent!=null'>and moduleParent is null</when> "
		,"</script>"})
	public List<ModuleInfo> queryModule(@Param("moduleParent")String moduleParent,@Param("isParent")String isParent);
	
	@Insert({"insert into sys_module(moduleId,modulename,moduleparent,moduleurl,moduleno,moduletype) "
			+ "values( MODULEID_seq.Nextval,#{moduleName,jdbcType=VARCHAR},"
			+ "#{moduleParent,jdbcType=VARCHAR},#{moduleURL,jdbcType=VARCHAR},"
			+ "#{moduleNo,jdbcType=VARCHAR},#{moduleType,jdbcType=VARCHAR})"})
	public void addModule(ModuleInfo moduleinfo);

	@Select("select moduleId,moduleName,moduleParent,moduleURL,moduleNo,moduleType "
			+ "from SYS_MODULE sm inner join sys_permission sp on sm.moduleid = sp.modelid "
			+ "where sp.roleid = #{roleId} order by moduleparent desc , moduleNo ")
	public List<ModuleInfo> findModuleByRoleId(@Param("roleId")int roleId);
	
	@Update({"<script>","UPDATE sys_module <trim prefix='set' suffixOverrides=','> "
			+ "<if test='moduleName!=null and moduleName!=\"\"'>moduleName = #{moduleName} ,</if>"
			+ "<if test='moduleParent!=null and moduleParent!=\"\"'> MODULEPARENT = #{moduleParent},</if>  "
			+ "<if test='moduleURL!=null and moduleURL!=\"\"'>MODULEURL = #{moduleURL},</if>  "
			+ "<if test='moduleNo!=null and moduleNo!=\"\"'>MODULENO = #{moduleNo},</if>  "
			+ "<if test='moduleType!=null and moduleType!=\"\"'> MODULETYPE = #{moduleType}</if> "
			+ "</trim> where moduleId = #{moduleId}","</script>"})
	public void editSystemModule(ModuleInfo moduleInfo);
	
	@Select("select moduleId,moduleName,moduleParent,moduleURL,moduleNo,moduleType,"
			+ "(select modulename from sys_module where moduleId = t.moduleParent) as moduleParentName from sys_module t where moduleId = #{moduleId}")
	public ModuleInfo findModuleById(@Param("moduleId")String moduleId);
	
	@Delete("delete sys_module where  moduleId = #{moduleId}")
	public void deleteModule(@Param("moduleId")String moduleId);
}
