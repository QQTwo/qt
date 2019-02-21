/**
 * Package: com.accp.dao.ylh
 * author: 阳灵慧
 * date: 2019年2月20日 下午3:49:33
 */
package com.accp.dao.ylh;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Servicecosttype;
import com.accp.pojo.Services;
import com.accp.pojo.Servicetype;


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
	public List<Servicetype> queryServicetype(@Param("stpid") int stpid);
	//新增服务
	public void addServices (@Param("s") Services services);
	
	public List<Servicecosttype> queryServicecosttype(@Param("stid") int stid);
}
