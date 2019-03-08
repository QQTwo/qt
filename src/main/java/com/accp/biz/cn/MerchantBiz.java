package com.accp.biz.cn;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.cn.IMerchantDao;
import com.accp.pojo.Appraisalapply;
import com.accp.pojo.Services;

import com.accp.pojo.User;
import com.accp.vo.cn2.EvaluationVo;
import com.accp.vo.cn2.ServicesVo;
import com.accp.vo.cn2.UserAppVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MerchantBiz {
	
	@Autowired
	private IMerchantDao merchantDao;
	
	public User queryUserinfo(String username) {
			return merchantDao.queryUserinfo(username);		
	}
	
	public User queryUserByid(Integer userid) {
		return merchantDao.queryUserByid(userid);		
	}
	
	public List<UserAppVo>  queryAppraisalapply(int userid,int oneid,int twoid){
		return merchantDao.queryAppraisalapply(userid, oneid, twoid);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void addAppraisalapply(Appraisalapply app) {
		
		merchantDao.addAppraisalapply(app);
		
	}
	
	public PageInfo<ServicesVo> queryServicesBytitle(Integer pageNum,Integer pageSize,String serviceTitle,Integer userid){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<ServicesVo>(merchantDao.queryServiceByTitle(serviceTitle,userid));
	}
	
	
	
	public PageInfo<ServicesVo> queryServices(Integer pageNum,Integer pageSize,Integer userid){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<ServicesVo>(merchantDao.queryServiceByTitle(null,userid));
	}
	
	public Services queryServices(int serviceid) {
			return merchantDao.queryService(serviceid);
		
		
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void addService(Services service) {
		
		merchantDao.addService(service);
		
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void removeService(int serviceID) {
		
		merchantDao.deleteService(serviceID);
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void modifyService(Services  service) {
		
		merchantDao.updateService(service);
	}
	
	public PageInfo<EvaluationVo> queryEvaluation(Integer pageNum,Integer pageSize,Integer userid){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<EvaluationVo>(merchantDao.queryEvaluation(userid));
	}
	
	//商家回复评价
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void replyComment(String content,int serviceAppraisePID) {
		merchantDao.replyComment(content, serviceAppraisePID);
	}

}
