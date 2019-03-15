package com.accp.action.ylh;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.ylh.SericesBiz;
import com.accp.pojo.Goldnotes;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.Majortype;
import com.accp.pojo.Putforward;
import com.accp.pojo.Services;
import com.accp.pojo.Servicetype;
import com.accp.pojo.User;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/ylh")
public class ServicesAction {
	@Autowired
	private SericesBiz biz;
	//服务类别
	/*@RequestMapping(value = "/queryServicetype/{stpid}", method = RequestMethod.GET)
	public List<Servicetype> queryServicetype(@PathVariable int stpid, Model model) {
		List<Servicetype>  servicetype= biz.queryServicetype(stpid);	
		return servicetype;
	}*/
	/*//服务类别
		@RequestMapping(value = "/gohwfyfb", method = RequestMethod.GET)
		public String gohwfyfb(Model model) {
			return "redirect:sjzx-hwfyfb";
		}*/
	
	/*//服务费用类型
	@RequestMapping(value = "/queryServicecosttype/{stid}", method = RequestMethod.GET)
	public Servicecosttype queryServicecosttype(@PathVariable int stid, Model model ) {
		Servicecosttype servicecosttype = biz.queryServicecosttype(stid);
		return servicecosttype;
	}*/
	
	//擅长的专业
		@RequestMapping(value = "/queryMajortype", method = RequestMethod.GET)
		public List<Majortype> queryMajortype() {
			List<Majortype> majortype = biz.queryMajortype();
			return majortype;
		}
	
	@RequestMapping(value = "/addServices", method = RequestMethod.POST)
	public Map<String, String> addServices(@RequestBody Services services) {
		Map<String, String> rs = new HashMap<String, String>();	
		//随机编码
		if(services.getServicecoverimg()!=null) 
		{
		String uuid = UUID.randomUUID().toString();
		String servicecoverimg = services.getServicecoverimg().substring(services.getServicecoverimg().indexOf("."));
		services.setServicecoverimg(uuid+"."+"jpg");
		}
		
		if(services.getServiceimgurlone()!=null) 
		{
		String uuid1 = UUID.randomUUID().toString();
		String serviceimgurlone = services.getServiceimgurlone().substring(services.getServiceimgurlone().indexOf("."));
		services.setServiceimgurlone(uuid1+"."+"jpg");
		}
		
		if(services.getServiceimgurltwo()!=null) 
		{
		String uuid2 = UUID.randomUUID().toString();
		String serviceimgurltwo = services.getServiceimgurltwo().substring(services.getServiceimgurltwo().indexOf("."));
		services.setServiceimgurltwo(uuid2+"."+"jpg");
		}
		
		if(services.getServiceimgurlthree()!=null) 
		{
		String uuid3 = UUID.randomUUID().toString();
		String serviceimgurlthree = services.getServiceimgurlthree().substring(services.getServiceimgurlthree().indexOf("."));
		services.setServiceimgurlthree(uuid3+"."+"jpg");
		}
		
		if(services.getServiceimgurlfour()!=null) 
		{
		String uuid4 = UUID.randomUUID().toString();
		String serviceimgurlfour = services.getServiceimgurlfour().substring(services.getServiceimgurlfour().indexOf("."));
		services.setServiceimgurlfour(uuid4+"."+"jpg");
		}
		/*File file = new File(url+"/"+uuid+suffix);*/
		
		biz.addServices(services);
		rs.put("code", "200");
		rs.put("msg", "ok");
		return rs;
	
	}	
	


@RequestMapping(value = "/queryGoldnotes/{pageNum}/{pageSize}/{acquisitionmode}/{userid}", method = RequestMethod.GET)
public PageInfo<Goldnotes> queryGoldnotes(@PathVariable Integer pageNum, @PathVariable Integer pageSize,@PathVariable int userid,@PathVariable int acquisitionmode, Model model, HttpSession session) {
	PageInfo<Goldnotes> goldnotes = biz.queryGoldnotes(pageNum, pageSize, userid, acquisitionmode);	
	return goldnotes;
}

//查询用户表
@RequestMapping(value = "/queryUser/{userid}", method = RequestMethod.GET)
public User queryUser(@PathVariable int userid, Model model) {
	User user = biz.queryUser(userid);
	System.out.println(user);
	return user;
}

@RequestMapping(value = "/queryIntegralrecord/{pageNum}/{pageSize}/{userid}", method = RequestMethod.GET)
public PageInfo<Integralrecord> queryIntegralrecord(@PathVariable Integer pageNum, @PathVariable Integer pageSize,@PathVariable int userid, Model model, HttpSession session) {
	PageInfo<Integralrecord> integralrecord = biz.queryIntegralrecord(pageNum, pageSize, userid);	
	return integralrecord;
}


@RequestMapping(value = "/addPutforward", method = RequestMethod.POST)
public Map<String, String> addPutforward(@RequestBody Putforward putforward) {
	Map<String, String> rs = new HashMap<String, String>();	
	putforward.setSubmittime(new Date());
	float Money=putforward.getMoney();
	biz.addPutforward(putforward);
	biz.updateUser(24, Money);
	rs.put("code", "200");
	rs.put("msg", "ok");
	return rs;
	}

@RequestMapping(value = "/queryService/{userid}", method = RequestMethod.GET)
public List<Services> queryServices(@PathVariable int userid, Model model) {
	List<Services>  service= biz.queryServices(userid);	
	return service;
}
}