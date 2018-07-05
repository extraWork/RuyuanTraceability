package com.spring.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Truckcompany implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TruckCompany.TruckId
     *
     * @mbg.generated
     */
    private BigDecimal truckid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TruckCompany.CompanyId
     *
     * @mbg.generated
     */
    private BigDecimal companyid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TruckCompany
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TruckCompany.TruckId
     *
     * @return the value of TruckCompany.TruckId
     *
     * @mbg.generated
     */
    public BigDecimal getTruckid() {
        return truckid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TruckCompany.TruckId
     *
     * @param truckid the value for TruckCompany.TruckId
     *
     * @mbg.generated
     */
    public void setTruckid(BigDecimal truckid) {
        this.truckid = truckid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TruckCompany.CompanyId
     *
     * @return the value of TruckCompany.CompanyId
     *
     * @mbg.generated
     */
    public BigDecimal getCompanyid() {
        return companyid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TruckCompany.CompanyId
     *
     * @param companyid the value for TruckCompany.CompanyId
     *
     * @mbg.generated
     */
    public void setCompanyid(BigDecimal companyid) {
        this.companyid = companyid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TruckCompany
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", truckid=").append(truckid);
        sb.append(", companyid=").append(companyid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}