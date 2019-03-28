package com.accp.biz.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import com.accp.util.Pager;
import com.accp.utils.RedisBaseOps;
import com.accp.vo.cn.TotalRetrieveVo;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class RedisBiz {

	@Autowired
	private RedisBaseOps rbo;
	
	@Autowired
	private MerchantBiz mebiz;
	
	@Autowired
	private RedisTemplate<String, Object> rt;
	
	
	/**
	 * 查询全栈搜索
	 */
	
	public Pager<TotalRetrieveVo> querysearch(String service,Integer pageIndex,Integer pageSize,int Pop_Pice){
	
		List<TotalRetrieveVo> list2=null;	
		if(service=="") {
			 list2=mebiz.findPagerServices();
		}			
		Cursor<Object> iter=rt.opsForSet().scan("set:TotalRetrieveVo", ScanOptions.scanOptions().match("*"+service+"*").build());			
		 list2=new ArrayList<TotalRetrieveVo>();
		while(iter.hasNext()) {
			String data=iter.next().toString();
			list2.add(JSON.parseObject(data,TotalRetrieveVo.class));			
		}
	
		
		//分页
		List<TotalRetrieveVo> pageList;
		int max = pageIndex*pageSize;
		if(max<list2.size()) {
			pageList = list2.subList((pageIndex-1)*pageSize, max);
		}else {
			pageList = list2.subList((pageIndex-1)*pageSize, list2.size());
		}
		
		//排序
		if(pageList.size()>0) {
			pageList.sort(new Comparator<TotalRetrieveVo>() {
				@Override
				public int compare(TotalRetrieveVo o1, TotalRetrieveVo o2) {
					// TODO Auto-generated method stub
					if(Pop_Pice==1) {
						return (int)(o1.getBrowseNumber()-o2.getBrowseNumber());
					}else if(Pop_Pice==2){
						return (o2.getBrowseNumber()-o1.getBrowseNumber());
					}else if(Pop_Pice ==3) {
						return (int)(o2.getServicePrice()-o1.getServicePrice());
					}else {
						return (int)(o1.getServicePrice()-o2.getServicePrice());
					}
				}});
		}
		// 定义一个分页类对象
		Pager<TotalRetrieveVo> pager = new Pager<TotalRetrieveVo>(pageIndex, pageSize, list2.size(),pageList);
		return pager;		
	}
}
