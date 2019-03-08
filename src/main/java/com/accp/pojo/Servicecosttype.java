package com.accp.pojo;

public class Servicecosttype {
    private Integer servicecosttypeid;//	服务费用类型编号

    private String servicecosttypename;//服务费用类型名称

    private Integer stid;//服务类别编号

    public Integer getServicecosttypeid() {
        return servicecosttypeid;
    }

    public void setServicecosttypeid(Integer servicecosttypeid) {
        this.servicecosttypeid = servicecosttypeid;
    }

    public String getServicecosttypename() {
        return servicecosttypename;
    }

    public void setServicecosttypename(String servicecosttypename) {
        this.servicecosttypename = servicecosttypename == null ? null : servicecosttypename.trim();
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }
}