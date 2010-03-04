package com.video.util;

import java.util.List;

/**
 * 分页对象
 * 
 * @author Marshal Wu
 * 
 */
public class Pagination<T> {
	private int no;

	private int size;

	private List<T> results;

	private int recordSum;

	private String orderFieldName;

	private boolean desc;

	private Object condition;

	public Object getCondition() {
		return condition;
	}

	public void setCondition(Object condition) {
		this.condition = condition;
	}

	public int getStartIndex() {
		return (this.getNo() - 1) * this.getSize();
	}
	
	public int getEndIndex(){
		return this.getNo() * this.getSize();
	}

	public int getNo() {

		if (!(this.recordSum > 0 && this.recordSum > this.size * (this.no - 1))) {
			this.no = this.getPageSum();
		}

		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getRecordSum() {
		return recordSum;
	}

	public void setRecordSum(int recordSum) {
		this.recordSum = recordSum;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public int getSize() {
		return size;
	}

	public int getPageSum() {
		return (int) Math.ceil((double) recordSum / this.size);
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
	}

	public boolean isNext() {
		return this.no < this.getPageSum();
	}

	public boolean isPrevious() {
		return this.no > 1;
	}

	public boolean isFirst() {
		return this.no == 1;
	}

	public boolean isLast() {
		return this.no == this.getPageSum();
	}

	public String getOrderFieldName() {
		return orderFieldName;
	}

	public void setOrderFieldName(String orderFieldName) {
		this.orderFieldName = orderFieldName;
	}
}
