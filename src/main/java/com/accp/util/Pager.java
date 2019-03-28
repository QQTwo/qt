package com.accp.util;

import java.util.List;

public class Pager<T> {

	//当前页。
	private int pageIndex;
	
	//每页记录数
	private int pageSize;
	
	//总页数
	private int totalPage; 
	
	//总记录数
	private int totaRecord;
	
	//上一页
	private int prevPage;
	
	//下一页
	private int nextPage;
	
	//当前页的数据
	private List<T> listPager;

	public int getPageIndex() {
		return pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getTotaRecord() {
		return totaRecord;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}


	public List<T> getListPager() {
		return listPager;
	}

	/**
	 * 
	 * @param pageIndex //当前页
	 * @param pageSize //每页的数量
	 * @param totalRecord //总记录数
	 * @param list
	 */
	public Pager(int pageIndex,int pageSize,int totalRecord,List<T> list){
		 this.pageSize = pageSize;//每页的数量
		 this.pageIndex = pageIndex;//当前页
		 this.totaRecord = totalRecord;//总记录数
		 this.listPager = list;
		 
		 //总页数
		 this.totalPage = (this.totaRecord-1) / this.pageSize+1;
		 
		 //上一页
		 prevPage = this.pageIndex > 1 ?this.pageIndex-1:this.pageIndex;
		 
		 //下一页
		 nextPage = this.pageIndex < this.totalPage?this.pageIndex+1:this.pageIndex;
		 
		 
		
	}
	
}
