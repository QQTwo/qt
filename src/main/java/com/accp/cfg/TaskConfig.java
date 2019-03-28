package com.accp.cfg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.accp.biz.cn.MerchantBiz;
import com.accp.utils.RedisBaseOps;
import com.accp.vo.cn.TotalRetrieveVo;
import com.alibaba.fastjson.JSON;

@Configuration
@EnableScheduling
public class TaskConfig {
	@Autowired
	private MerchantBiz mebiz;
	@Autowired
	private RedisBaseOps redisUtils;
	
	@Autowired
	private RedisTemplate<String, Object> rt;

	@Autowired
	private RedisBaseOps rbo;
	// 实现【定时从mysql中查询所有消息信息，然后循环插入redis（Hashes）中，完成读写分离同步】
	@Scheduled(cron = "0/40 * * * * ?")
	public void doSynRedis() {
		List<TotalRetrieveVo> list=mebiz.findPagerServices();
		rt.delete("set:TotalRetrieveVo");
		//循环添加 list set
		for(TotalRetrieveVo total:list) {
			rt.opsForList().leftPush("new:message", total);
			rt.opsForSet().add("set:TotalRetrieveVo", total);
		
		}
	}

}
