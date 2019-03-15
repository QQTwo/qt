package com.accp.dao.cn;

import java.util.List;




import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Appraisalapply;
import com.accp.pojo.Evaluationservice;
import com.accp.pojo.Services;
import com.accp.pojo.User;
import com.accp.vo.cn2.EvaluationVo;
import com.accp.vo.cn2.ServicesVo;
import com.accp.vo.cn2.UserAppVo;
public interface IMerchantDao {
	
	
	  public User  queryUserinfo(@Param("username")String username);
	  
	  
	  public User queryUserByid(@Param("userid")Integer userid);
	  
	  public List<ServicesVo> queryServiceByTitle(@Param("serviceTitle") String serviceTitle,@Param("userid")Integer userid);
	  
	  public Services  queryService(@Param("serviceid")int serviceid);
	  
	  public int addService(@Param("services")Services service);
	  
	  public int updateService(@Param("services")Services service);
	  
	  public int deleteService(@Param("serviceID")int serviceID);
	  
	  //public UserAppVo queryAppraisalapply(@Param("userid") int userid);
	   	
	  public List<UserAppVo>  queryAppraisalapply(@Param("userid") int userid ,@Param("oneid") int oneid,@Param("twoid") int twoid);
	  
	  public int addAppraisalapply(@Param("pojo") Appraisalapply pojo);
	  //查询评价内容
	  public List<EvaluationVo>  queryEvaluation(@Param("userid") int userid);
	  //商家回复评论
	  public int replyComment(@Param("content") String content,@Param("serviceAppraisePID")int serviceAppraisePID);
	//查看店家回复
	  public Evaluationservice queryShopReply(@Param("serviceAppraisePID")int serviceAppraisePID);
}
