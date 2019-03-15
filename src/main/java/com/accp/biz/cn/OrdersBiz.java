package com.accp.biz.cn;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.cn.IOrdersDao;
import com.accp.pojo.Orders;
import com.accp.pojo.Servicetype;
import com.accp.vo.cn.OrderInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class OrdersBiz {
	@Autowired
	private IOrdersDao dao;
	/**
	 * 查询当前登陆用户预定信息
	 * @return
	 */
	public  PageInfo<OrderInfoVo>  queryUserOrder(Integer userID,Integer orderStatus,Integer refundstatus,String orderID,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		System.out.println("订单状态："+orderStatus);
		return new PageInfo<>(dao.queryUserOrder(userID, orderStatus, refundstatus,orderID));
	}
	/**
	 * 查询服务类型
	 * @param stid
	 * @return
	 */
	public Servicetype querySerType(Integer stid) {
		return dao.querySerType(stid);
	}
	/**
	 * 修改订单
	 * @param orderStatus
	 * @param orderID
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updateOrders(Integer orderStatus,String orderID) {
		return dao.updateOrders(orderStatus, orderID);
	}
	/**
	 * 查询所有订单
	 * @param userID
	 * @return
	 */
	public List<Orders> queryCountOrder(Integer userID) {
		return dao.queryCountOrder(userID);
	}
	/**
	 * 查询单个订单详情
	 * @param orderID 订单ID
	 * @return
	 */
	public OrderInfoVo queryAOrder(String orderID) {
		return dao.queryAOrder(orderID);
	}
	/**
	 * 删除我发布的服务之前的查询
	 * 
	 */
	public int querydelCount(int serviceid) {
		return dao.querydelCount(serviceid);
	}
}
