package com.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.domain.UserInfo;

public interface UserManagerDao {
	/**
	 * 新增用户信息
	 * @param userInfo 用户信息
	 * @return
	 */
	@Insert({"insert into SYS_USER"
			+ "(USERID,USERCODE,USERPWD,USERNAME,TELEPHONE,EMAIL,FLAG,"
			+ "COMPANYNAME,COMPANYID,IDENTIFYNO,ROLENAME,ROLEID,createDate)"
			+ "values(SYS_USER_SEQ.Nextval,"
			+ "#{userCode,jdbcType=VARCHAR},#{userPWD,jdbcType=VARCHAR},"
			+ "#{userName,jdbcType=VARCHAR},#{telephone,jdbcType=VARCHAR},"
			+ "#{email,jdbcType=VARCHAR},#{flag,jdbcType=VARCHAR},"
			+ "#{companyName,jdbcType=VARCHAR},#{companyId},"
			+ "#{identifyNo,jdbcType=VARCHAR},#{roleName,jdbcType=VARCHAR},"
			+ "#{roleId},sysdate)"})
	public int saveUser(UserInfo userInfo);
	
	@Select({"<script>","select USERID,USERCODE,userPWD,USERNAME,TELEPHONE,"
			+ "EMAIL,flag,COMPANYNAME,COMPANYID,IDENTIFYNO,ROLENAME,ROLEID,createDate "
			+ "from SYS_USER  <where> "
			+ "<if test=\"userCode != null and userCode!=''\"> userCode like concat(concat('%',#{userCode}),'%') </if>"
			+ "<if test=\"userName != null and userName!=''\"> and userName = concat(concat('%',#{userName}),'%') </if>"
			+ "<if test=\"flag != null and flag!=''\">and flag = #{flag} </if></where>","</script>"})
	public List<UserInfo> queryUserByParam(@Param("userName")String userName, @Param("userCode")String userCode, @Param("flag")String flag);
	
	@Delete({"<script>",
			"delete from SYS_USER where userId in  "
			+ "<foreach item='item' index='index' collection='users' open=\"(\" separator=\",\" close=\")\">"
			+ "#{item.userId} </foreach>"
			,"</script>"})
	public void deleteUser(@Param("users")UserInfo[] users);
	
	@Update({"<script>","UPDATE SYS_USER <trim prefix=\"set\" suffixOverrides=','>" + 
			"<if test='userCode!=null'>userCode= #{userCode},</if><if test='userPWD!=null'>userPWD= #{userPWD},</if>" + 
			"<if test='userName!=null'>userName= #{userName},</if><if test='telephone!=null'>telephone = #{telephone},</if>" + 
			"<if test='email!=null'>email= #{email},</if><if test='flag!=null'>flag= #{flag},</if>" + 
			"<if test='companyName!=null'>companyName = #{companyName},</if><if test='companyId!=null'>companyId= #{companyId},</if>" + 
			"<if test='identifyNo!=null'>identifyNo= #{identifyNo},</if><if test='roleName!=null'>roleName= #{roleName},</if>" + 
			"<if test='roleId!=null'>roleId= #{roleId},</if></trim>" + 
			"where userId = #{userId}","</script>"})
	public int editUser(UserInfo user);
	
	@Select("select USERID,USERCODE,userPWD,USERNAME,TELEPHONE,EMAIL,"
			+ "flag,COMPANYNAME,COMPANYID,IDENTIFYNO,ROLENAME,ROLEID,createDate "
			+ "from SYS_USER "
			+ "where userCode=#{loginName} and userPWD=#{loginPWD}")
	public UserInfo login(@Param("loginName")String loginName, @Param("loginPWD")String loginPWD);
}
