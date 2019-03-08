/**
 * Package: com.accp.dao.ylh
 * author: 阳灵慧
 * date: 2019年2月20日 下午3:49:33
 */
package com.accp.dao.ylh;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Goldnotes;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.Majortype;
import com.accp.pojo.Putforward;
import com.accp.pojo.Services;
import com.accp.pojo.User;



/** * @author 阳灵慧：* @date 创建时间：2019年2月20日 下午3:49:33
* @version V1.0 * @parameter * @since * @return */
/**
 * @ClassName: ISericesDao
 * @Description: TODO
 * @author 阳灵慧
 * @date: 2019年2月20日 下午3:49:33
 */
public interface ISericesDao {
	//服务类别
	/*public List<Servicetype> queryServicetype(@Param("stpid") int stpid);*/
	//新增服务
	public void addServices (@Param("s") Services services);
	 
	public List<Services> queryServices(@Param("userid") int userid);
	/*//服务费用类型
	public List<Servicecosttype> queryServicecosttype(@Param("stid") int stid);*/
	
	public List<Majortype> queryMajortype();
	
	//查询金币表
	public List<Goldnotes> queryGoldnotes(@Param("userid") int userid,@Param("acquisitionmode") int acquisitionmode);
	
	//查询用户表
	public User queryUser(@Param("userid") int userid);
	
	//积分表
	public List<Integralrecord> queryIntegralrecord(@Param("userid") int userid);
	
	//提现
	public void addPutforward (@Param("s") Putforward putforward);
	
	public void updateUser(@Param("userid") int userid,@Param("usermoney") float usermoney);
	
}
