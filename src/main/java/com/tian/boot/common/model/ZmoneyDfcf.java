package com.tian.boot.common.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Entity
public class ZmoneyDfcf implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String code;

    private String name;

    private Double currentPrice;

    private Double changeRate;

    private Double flowMoney;

    private Double flowRate;

    private Double largeBigMoney;

    private Double largeBigRate;

    private Double bigMoney;

    private Double bigRate;

    private Double midMoney;

    private Double midRate;

    private Double smaMoney;

    private Double smaRate;

    private String today;

    private Date cdate;

    private Integer num;

    private Double flowMoneyFirst;

    private Double flowRateFirst;

    private Double largeBigMoneyFirst;

    private Double largeBigRateFirst;

    private Double bigMoneyFirst;

    private Double bigRateFirst;

    private Double flowMoneyChange;

    private Double flowRateChange;

    private Double largeBigMoneyChange;

    private Double largeBigRateChange;

    private Double bigMoneyChange;

    private Double bigRateChange;
    
    private Integer pmNum;
    

    public Integer getPmNum() {
		return pmNum;
	}

	public void setPmNum(Integer pmNum) {
		this.pmNum = pmNum;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(Double changeRate) {
        this.changeRate = changeRate;
    }

    public Double getFlowMoney() {
        return flowMoney;
    }

    public void setFlowMoney(Double flowMoney) {
        this.flowMoney = flowMoney;
    }

    public Double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(Double flowRate) {
        this.flowRate = flowRate;
    }

    public Double getLargeBigMoney() {
        return largeBigMoney;
    }

    public void setLargeBigMoney(Double largeBigMoney) {
        this.largeBigMoney = largeBigMoney;
    }

    public Double getLargeBigRate() {
        return largeBigRate;
    }

    public void setLargeBigRate(Double largeBigRate) {
        this.largeBigRate = largeBigRate;
    }

    public Double getBigMoney() {
        return bigMoney;
    }

    public void setBigMoney(Double bigMoney) {
        this.bigMoney = bigMoney;
    }

    public Double getBigRate() {
        return bigRate;
    }

    public void setBigRate(Double bigRate) {
        this.bigRate = bigRate;
    }

    public Double getMidMoney() {
        return midMoney;
    }

    public void setMidMoney(Double midMoney) {
        this.midMoney = midMoney;
    }

    public Double getMidRate() {
        return midRate;
    }

    public void setMidRate(Double midRate) {
        this.midRate = midRate;
    }

    public Double getSmaMoney() {
        return smaMoney;
    }

    public void setSmaMoney(Double smaMoney) {
        this.smaMoney = smaMoney;
    }

    public Double getSmaRate() {
        return smaRate;
    }

    public void setSmaRate(Double smaRate) {
        this.smaRate = smaRate;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today == null ? null : today.trim();
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getFlowMoneyFirst() {
        return flowMoneyFirst;
    }

    public void setFlowMoneyFirst(Double flowMoneyFirst) {
        this.flowMoneyFirst = flowMoneyFirst;
    }

    public Double getFlowRateFirst() {
        return flowRateFirst;
    }

    public void setFlowRateFirst(Double flowRateFirst) {
        this.flowRateFirst = flowRateFirst;
    }

    public Double getLargeBigMoneyFirst() {
        return largeBigMoneyFirst;
    }

    public void setLargeBigMoneyFirst(Double largeBigMoneyFirst) {
        this.largeBigMoneyFirst = largeBigMoneyFirst;
    }

    public Double getLargeBigRateFirst() {
        return largeBigRateFirst;
    }

    public void setLargeBigRateFirst(Double largeBigRateFirst) {
        this.largeBigRateFirst = largeBigRateFirst;
    }

    public Double getBigMoneyFirst() {
        return bigMoneyFirst;
    }

    public void setBigMoneyFirst(Double bigMoneyFirst) {
        this.bigMoneyFirst = bigMoneyFirst;
    }

    public Double getBigRateFirst() {
        return bigRateFirst;
    }

    public void setBigRateFirst(Double bigRateFirst) {
        this.bigRateFirst = bigRateFirst;
    }

    public Double getFlowMoneyChange() {
        return flowMoneyChange;
    }

    public void setFlowMoneyChange(Double flowMoneyChange) {
        this.flowMoneyChange = flowMoneyChange;
    }

    public Double getFlowRateChange() {
        return flowRateChange;
    }

    public void setFlowRateChange(Double flowRateChange) {
        this.flowRateChange = flowRateChange;
    }

    public Double getLargeBigMoneyChange() {
        return largeBigMoneyChange;
    }

    public void setLargeBigMoneyChange(Double largeBigMoneyChange) {
        this.largeBigMoneyChange = largeBigMoneyChange;
    }

    public Double getLargeBigRateChange() {
        return largeBigRateChange;
    }

    public void setLargeBigRateChange(Double largeBigRateChange) {
        this.largeBigRateChange = largeBigRateChange;
    }

    public Double getBigMoneyChange() {
        return bigMoneyChange;
    }

    public void setBigMoneyChange(Double bigMoneyChange) {
        this.bigMoneyChange = bigMoneyChange;
    }

    public Double getBigRateChange() {
        return bigRateChange;
    }

    public void setBigRateChange(Double bigRateChange) {
        this.bigRateChange = bigRateChange;
    }
}