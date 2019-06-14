package com.tian.boot.common.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Entity
public class ZlpmThs implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String code;

    private String name;

    private Double currentPrice;

    private Double changeRate;

    private Double zlLv;

    private Integer pm1;

    private Double changeRateFive;

    private Double zlLvFive;

    private Double pm1Fiv;

    private Double changeRateTen;

    private Double zlLvTen;

    private Double pm1Ten;

    private String bankuai;

    private String today;

    private Date cdate;
    
    private Integer num;

    private Integer pmNum;

    private Integer pmNumFirst;

    private Double zlLvChange;

    private Double zlLvChangeFirst;
    
    private Integer firstPm;
    
    private Double firstZl;
    
    

    public Integer getFirstPm() {
		return firstPm;
	}

	public void setFirstPm(Integer firstPm) {
		this.firstPm = firstPm;
	}

	public Double getFirstZl() {
		return firstZl;
	}

	public void setFirstZl(Double firstZl) {
		this.firstZl = firstZl;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getPmNum() {
		return pmNum;
	}

	public void setPmNum(Integer pmNum) {
		this.pmNum = pmNum;
	}

	public Integer getPmNumFirst() {
		return pmNumFirst;
	}

	public void setPmNumFirst(Integer pmNumFirst) {
		this.pmNumFirst = pmNumFirst;
	}

	public Double getZlLvChange() {
		return zlLvChange;
	}

	public void setZlLvChange(Double zlLvChange) {
		this.zlLvChange = zlLvChange;
	}

	public Double getZlLvChangeFirst() {
		return zlLvChangeFirst;
	}

	public void setZlLvChangeFirst(Double zlLvChangeFirst) {
		this.zlLvChangeFirst = zlLvChangeFirst;
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

    public Double getZlLv() {
        return zlLv;
    }

    public void setZlLv(Double zlLv) {
        this.zlLv = zlLv;
    }

  

    public Integer getPm1() {
		return pm1;
	}

	public void setPm1(Integer pm1) {
		this.pm1 = pm1;
	}

	public Double getChangeRateFive() {
        return changeRateFive;
    }

    public void setChangeRateFive(Double changeRateFive) {
        this.changeRateFive = changeRateFive;
    }

    public Double getZlLvFive() {
        return zlLvFive;
    }

    public void setZlLvFive(Double zlLvFive) {
        this.zlLvFive = zlLvFive;
    }

    public Double getPm1Fiv() {
        return pm1Fiv;
    }

    public void setPm1Fiv(Double pm1Fiv) {
        this.pm1Fiv = pm1Fiv;
    }

    public Double getChangeRateTen() {
        return changeRateTen;
    }

    public void setChangeRateTen(Double changeRateTen) {
        this.changeRateTen = changeRateTen;
    }

    public Double getZlLvTen() {
        return zlLvTen;
    }

    public void setZlLvTen(Double zlLvTen) {
        this.zlLvTen = zlLvTen;
    }

    public Double getPm1Ten() {
        return pm1Ten;
    }

    public void setPm1Ten(Double pm1Ten) {
        this.pm1Ten = pm1Ten;
    }

    public String getBankuai() {
        return bankuai;
    }

    public void setBankuai(String bankuai) {
        this.bankuai = bankuai == null ? null : bankuai.trim();
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
}