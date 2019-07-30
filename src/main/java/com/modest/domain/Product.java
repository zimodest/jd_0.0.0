package com.modest.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * description
 *
 * @author modest
 * @date 2019/07/28
 */
public class Product implements Serializable {

    /**
     * 商品编号
     */
    private String pid;

    /**
     * 商品名称
     */
    private String pname;

    /**
     * 市场价格
     */
    private Double market_price;

    /**
     * 商城价格
     */
    private Double shop_price;

    /**
     * 商品图片
     */
    private String pimage;

    /**
     * 商品创建日期
     */
    private Date pdate;

    /**
     * 是否是热门商品
     */
    private Integer is_hot = 1;

    /**
     * 商品描述
     */
    private String pdesc;

    /**
     * 商品是否下架
     */
    private Integer pflag = 1;

    /**
     * 商品分类
     */
    private Category category;


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(Double market_price) {
        this.market_price = market_price;
    }

    public Double getShop_price() {
        return shop_price;
    }

    public void setShop_price(Double shop_price) {
        this.shop_price = shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getPflag() {
        return pflag;
    }

    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
