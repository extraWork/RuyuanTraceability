package com.spring.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Milksequence implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.mcId
     *
     * @mbg.generated
     */
    private BigDecimal mcid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.CompanyId
     *
     * @mbg.generated
     */
    private BigDecimal companyid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.mcNo
     *
     * @mbg.generated
     */
    private String mcno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.HandoverId
     *
     * @mbg.generated
     */
    private BigDecimal handoverid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.CompanyName
     *
     * @mbg.generated
     */
    private String companyname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.startDate
     *
     * @mbg.generated
     */
    private Date startdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.endDate
     *
     * @mbg.generated
     */
    private Date enddate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.startWeight
     *
     * @mbg.generated
     */
    private String startweight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.endWeight
     *
     * @mbg.generated
     */
    private String endweight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.weight
     *
     * @mbg.generated
     */
    private String weight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.createDate
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.attrbute1
     *
     * @mbg.generated
     */
    private String attrbute1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.attrbute2
     *
     * @mbg.generated
     */
    private String attrbute2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.attrbute3
     *
     * @mbg.generated
     */
    private String attrbute3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.attrbute4
     *
     * @mbg.generated
     */
    private String attrbute4;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MilkSequence.attrbute5
     *
     * @mbg.generated
     */
    private String attrbute5;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table MilkSequence
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.mcId
     *
     * @return the value of MilkSequence.mcId
     *
     * @mbg.generated
     */
    public BigDecimal getMcid() {
        return mcid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.mcId
     *
     * @param mcid the value for MilkSequence.mcId
     *
     * @mbg.generated
     */
    public void setMcid(BigDecimal mcid) {
        this.mcid = mcid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.CompanyId
     *
     * @return the value of MilkSequence.CompanyId
     *
     * @mbg.generated
     */
    public BigDecimal getCompanyid() {
        return companyid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.CompanyId
     *
     * @param companyid the value for MilkSequence.CompanyId
     *
     * @mbg.generated
     */
    public void setCompanyid(BigDecimal companyid) {
        this.companyid = companyid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.mcNo
     *
     * @return the value of MilkSequence.mcNo
     *
     * @mbg.generated
     */
    public String getMcno() {
        return mcno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.mcNo
     *
     * @param mcno the value for MilkSequence.mcNo
     *
     * @mbg.generated
     */
    public void setMcno(String mcno) {
        this.mcno = mcno == null ? null : mcno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.HandoverId
     *
     * @return the value of MilkSequence.HandoverId
     *
     * @mbg.generated
     */
    public BigDecimal getHandoverid() {
        return handoverid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.HandoverId
     *
     * @param handoverid the value for MilkSequence.HandoverId
     *
     * @mbg.generated
     */
    public void setHandoverid(BigDecimal handoverid) {
        this.handoverid = handoverid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.CompanyName
     *
     * @return the value of MilkSequence.CompanyName
     *
     * @mbg.generated
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.CompanyName
     *
     * @param companyname the value for MilkSequence.CompanyName
     *
     * @mbg.generated
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.startDate
     *
     * @return the value of MilkSequence.startDate
     *
     * @mbg.generated
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.startDate
     *
     * @param startdate the value for MilkSequence.startDate
     *
     * @mbg.generated
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.endDate
     *
     * @return the value of MilkSequence.endDate
     *
     * @mbg.generated
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.endDate
     *
     * @param enddate the value for MilkSequence.endDate
     *
     * @mbg.generated
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.startWeight
     *
     * @return the value of MilkSequence.startWeight
     *
     * @mbg.generated
     */
    public String getStartweight() {
        return startweight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.startWeight
     *
     * @param startweight the value for MilkSequence.startWeight
     *
     * @mbg.generated
     */
    public void setStartweight(String startweight) {
        this.startweight = startweight == null ? null : startweight.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.endWeight
     *
     * @return the value of MilkSequence.endWeight
     *
     * @mbg.generated
     */
    public String getEndweight() {
        return endweight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.endWeight
     *
     * @param endweight the value for MilkSequence.endWeight
     *
     * @mbg.generated
     */
    public void setEndweight(String endweight) {
        this.endweight = endweight == null ? null : endweight.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.weight
     *
     * @return the value of MilkSequence.weight
     *
     * @mbg.generated
     */
    public String getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.weight
     *
     * @param weight the value for MilkSequence.weight
     *
     * @mbg.generated
     */
    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.createDate
     *
     * @return the value of MilkSequence.createDate
     *
     * @mbg.generated
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.createDate
     *
     * @param createdate the value for MilkSequence.createDate
     *
     * @mbg.generated
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.attrbute1
     *
     * @return the value of MilkSequence.attrbute1
     *
     * @mbg.generated
     */
    public String getAttrbute1() {
        return attrbute1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.attrbute1
     *
     * @param attrbute1 the value for MilkSequence.attrbute1
     *
     * @mbg.generated
     */
    public void setAttrbute1(String attrbute1) {
        this.attrbute1 = attrbute1 == null ? null : attrbute1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.attrbute2
     *
     * @return the value of MilkSequence.attrbute2
     *
     * @mbg.generated
     */
    public String getAttrbute2() {
        return attrbute2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.attrbute2
     *
     * @param attrbute2 the value for MilkSequence.attrbute2
     *
     * @mbg.generated
     */
    public void setAttrbute2(String attrbute2) {
        this.attrbute2 = attrbute2 == null ? null : attrbute2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.attrbute3
     *
     * @return the value of MilkSequence.attrbute3
     *
     * @mbg.generated
     */
    public String getAttrbute3() {
        return attrbute3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.attrbute3
     *
     * @param attrbute3 the value for MilkSequence.attrbute3
     *
     * @mbg.generated
     */
    public void setAttrbute3(String attrbute3) {
        this.attrbute3 = attrbute3 == null ? null : attrbute3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.attrbute4
     *
     * @return the value of MilkSequence.attrbute4
     *
     * @mbg.generated
     */
    public String getAttrbute4() {
        return attrbute4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.attrbute4
     *
     * @param attrbute4 the value for MilkSequence.attrbute4
     *
     * @mbg.generated
     */
    public void setAttrbute4(String attrbute4) {
        this.attrbute4 = attrbute4 == null ? null : attrbute4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MilkSequence.attrbute5
     *
     * @return the value of MilkSequence.attrbute5
     *
     * @mbg.generated
     */
    public String getAttrbute5() {
        return attrbute5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MilkSequence.attrbute5
     *
     * @param attrbute5 the value for MilkSequence.attrbute5
     *
     * @mbg.generated
     */
    public void setAttrbute5(String attrbute5) {
        this.attrbute5 = attrbute5 == null ? null : attrbute5.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MilkSequence
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mcid=").append(mcid);
        sb.append(", companyid=").append(companyid);
        sb.append(", mcno=").append(mcno);
        sb.append(", handoverid=").append(handoverid);
        sb.append(", companyname=").append(companyname);
        sb.append(", startdate=").append(startdate);
        sb.append(", enddate=").append(enddate);
        sb.append(", startweight=").append(startweight);
        sb.append(", endweight=").append(endweight);
        sb.append(", weight=").append(weight);
        sb.append(", createdate=").append(createdate);
        sb.append(", attrbute1=").append(attrbute1);
        sb.append(", attrbute2=").append(attrbute2);
        sb.append(", attrbute3=").append(attrbute3);
        sb.append(", attrbute4=").append(attrbute4);
        sb.append(", attrbute5=").append(attrbute5);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}