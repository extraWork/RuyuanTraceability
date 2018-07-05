package com.spring.dao;

import com.spring.domain.Handover;
import java.math.BigDecimal;
import java.util.List;

public interface HandoverMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Handover
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(BigDecimal handoverid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Handover
     *
     * @mbg.generated
     */
    int insert(Handover record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Handover
     *
     * @mbg.generated
     */
    Handover selectByPrimaryKey(BigDecimal handoverid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Handover
     *
     * @mbg.generated
     */
    List<Handover> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Handover
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Handover record);
}