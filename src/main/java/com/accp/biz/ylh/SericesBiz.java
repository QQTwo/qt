package com.accp.biz.ylh;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.ylh.ISericesDao;
import com.accp.pojo.Majortype;
import com.accp.pojo.Services;
import com.accp.pojo.Servicetype;

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
}
