package com.accp.action.ylh;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.ylh.SericesBiz;
import com.accp.pojo.Majortype;
import com.accp.pojo.Services;
import com.accp.pojo.Servicetype;

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
			System.out.println(majortype+"123");
			return majortype;
		}
	
	@RequestMapping(value = "/addServices", method = RequestMethod.POST)
	public Map<String, String> addServices(@RequestBody Services services) {
		Map<String, String> rs = new HashMap<String, String>();	
		//随机编码
		String uuid = UUID.randomUUID().toString();
	//	String servicecoverimg = services.getServicecoverimg().substring(services.getServicecoverimg().indexOf("."));
		services.setServicecoverimg(uuid+"."+"jpg");
		
		String uuid1 = UUID.randomUUID().toString();
//		String serviceimgurlone = services.getServiceimgurlone().substring(services.getServiceimgurlone().indexOf("."));
		services.setServiceimgurlone(uuid1+"."+"jpg");
		
		/*String uuid2 = UUID.randomUUID().toString();
		String serviceimgurltwo = services.getServiceimgurltwo().substring(services.getServiceimgurltwo().indexOf("."));
		services.setServiceimgurltwo(uuid2+"."+"jpg");
		
		String uuid3 = UUID.randomUUID().toString();
		String serviceimgurlthree = services.getServiceimgurlthree().substring(services.getServiceimgurlthree().indexOf("."));
		services.setServiceimgurlthree(uuid3+"."+"jpg");
		
		String uuid4 = UUID.randomUUID().toString();
//		String serviceimgurlfour = services.getServiceimgurlfour().substring(services.getServiceimgurlfour().indexOf("."));
		services.setServiceimgurlfour(uuid4+"."+"jpg");
		
		
		
		File file = new File(url+"/"+uuid+suffix);*/
		
		biz.addServices(services);
		rs.put("code", "200");
		rs.put("msg", "ok");
		return rs;
	
	}
}
