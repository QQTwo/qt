package com.accp.dao.gsq;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Evaluationservice;

public interface EvaluateDao {
	/**
	 * 保存评价
	 * 
	 * @param evaluate
	 *            评价
	 * @return
	 */
	boolean saveEvaluate(@Param("evaluate") Evaluationservice evaluate);
}