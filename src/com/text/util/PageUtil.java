package com.text.util;

import java.util.List;

public class PageUtil {

	private List date;
	
	private int rowCount;//总行数
	private int pageCount;//总页数
	private int pageSize;//每页显示的条数
	private int pageNum;//当前页数
	private int beginIndex;//开始索引值
	private int endIndex;//结束索引值
	
	public PageUtil(List date,int pageSize){
		this.date=date;
		this.pageSize=pageSize;
		
		this.rowCount=date.size();//总行数
		
		if(this.rowCount%this.pageSize==0){
			
			this.pageCount=this.rowCount/this.pageSize;
		}else{
			
			this.pageCount=this.rowCount/this.pageSize+1;
		}
		
		this.pageNum=1;
		
		this.setPageNum(this.pageNum);
	}
	public List getDate() {
		return date;
	}
	public void setDate(List date) {
		this.date = date;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		
		
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		
		this.pageNum = pageNum;
		
		//设置开始索引
		this.beginIndex=(this.pageNum-1)*this.pageSize+1;
		//结束索引
		this.endIndex=this.pageNum*this.pageSize;
		if(this.endIndex>this.rowCount){
			endIndex=this.rowCount;
		}
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
	
}
