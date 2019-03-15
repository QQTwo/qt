package com.accp.pojo;

public class Servicetype {
    private Integer stid;//服务类别id

    private Integer stpid;//递归编号(父ID)

    private String stname;//服务名称

    private Integer sort;//排序

    private Boolean display;//'是否显示(1不显示，2显示'

    private Integer operationtime;//未操作时间

    private Integer confirmtime;//自动确认时间

    private Integer violatednumber;//服务违约天数

    private Integer proportion;//违约金比例

    private Boolean toexamine;//是否审核（1未审核2审核）

    private String advertisement;//广告图片地址

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public Integer getStpid() {
        return stpid;
    }

    public void setStpid(Integer stpid) {
        this.stpid = stpid;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname == null ? null : stname.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Integer getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Integer operationtime) {
        this.operationtime = operationtime;
    }

    public Integer getConfirmtime() {
        return confirmtime;
    }

    public void setConfirmtime(Integer confirmtime) {
        this.confirmtime = confirmtime;
    }

    public Integer getViolatednumber() {
        return violatednumber;
    }

    public void setViolatednumber(Integer violatednumber) {
        this.violatednumber = violatednumber;
    }

    public Integer getProportion() {
        return proportion;
    }

    public void setProportion(Integer proportion) {
        this.proportion = proportion;
    }

    public Boolean getToexamine() {
        return toexamine;
    }

    public void setToexamine(Boolean toexamine) {
        this.toexamine = toexamine;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement == null ? null : advertisement.trim();
    }
}