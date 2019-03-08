package com.accp.biz.ylh;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.ylh.ISericesDao;
import com.accp.pojo.Goldnotes;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.Majortype;
import com.accp.pojo.Putforward;
import com.accp.pojo.Services;
import com.accp.pojo.Servicetype;
import com.accp.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("SericesBiz")
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class SericesBiz {
	@Autowired
	private  ISericesDao dao;
	//服务类别
		/*public List<Servicetype> queryServicetype( int stpid)
		{
			return dao.queryServicetype(stpid);
		}*/
		//新增服务
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
		public void addServices (Services services)
		{
			dao.addServices(services);
		}
		/*//查询服务费用类型表
		public List<Servicecosttype> queryServicecosttype(int stid)
		{
			return dao.queryServicecosttype(stid);
		}*/
		//查询所有专业
		public List<Majortype> queryMajortype()
		{
			return dao.queryMajortype();
		}
		
		public PageInfo<Goldnotes> queryGoldnotes(Integer pageNum, Integer pageSize,int userid,int acquisitionmode) {
			PageHelper.startPage(pageNum, pageSize);
			return new PageInfo<Goldnotes>(dao.queryGoldnotes(userid, acquisitionmode));
		}
		//用户表
		public User queryUser(int userid)
		{
			return dao.queryUser(userid);
		}
		
		//积分表	
		public PageInfo<Integralrecord> queryIntegralrecord(Integer pageNum, Integer pageSize,int userid) {
			PageHelper.startPage(pageNum, pageSize);
			return new PageInfo<Integralrecord>(dao.queryIntegralrecord(userid));
		}
		
		//金币提现
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
		public void addPutforward ( Putforward putforward)
		{
			dao.addPutforward(putforward);
		}
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
		public void  updateUser(int userid,float usermoney)
		{
			 dao.updateUser(userid, usermoney);
		}
		
		//我服务的类别
		public List<Services> queryServices(int userid)
		{
			return dao.queryServices(userid);
		}
		
}
