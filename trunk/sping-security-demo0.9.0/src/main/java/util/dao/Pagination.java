package util.dao;

import java.util.List;

/**
 * 分页对象。
 * 
 * @author Marshal Wu <a
 *         href="mailto:marshal.wu@gmail.com">marshal.wu@gmail.com</a>
 * 
 * @param <T>
 */
public class Pagination<T> {

	/** The no. */
	private int no = 1;

	/** The size. */
	private int size;

	/** The results. */
	private List<T> results;

	/** The record sum. */
	private int recordSum;

	/** The order field name. */
	private String orderFieldName;

	/** The desc. */
	private boolean desc;

	/** The conditon. */
	private Object conditon;

	/**
	 * Gets the conditon.
	 * 
	 * @return the conditon
	 */
	public Object getConditon() {
		return conditon;
	}

	/**
	 * Sets the conditon.
	 * 
	 * @param conditon
	 *            the conditon
	 */
	public void setConditon(Object conditon) {
		this.conditon = conditon;
	}

	/**
	 * Gets the no.
	 * 
	 * @return the no
	 */
	public int getNo() {

		if (this.results != null
				&& !(this.recordSum > 0 && this.recordSum > this.size
						* (this.no - 1))) {
			this.no = this.getPageSum();
		}

		return no;
	}

	/**
	 * Sets the no.
	 * 
	 * @param no
	 *            the no
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * Gets the record sum.
	 * 
	 * @return the record sum
	 */
	public int getRecordSum() {
		return recordSum;
	}

	/**
	 * Sets the record sum.
	 * 
	 * @param recordSum
	 *            the record sum
	 */
	public void setRecordSum(int recordSum) {
		this.recordSum = recordSum;
	}

	/**
	 * Gets the results.
	 * 
	 * @return the results
	 */
	public List<T> getResults() {
		return results;
	}

	/**
	 * Sets the results.
	 * 
	 * @param results
	 *            the results
	 */
	public void setResults(List<T> results) {
		this.results = results;
	}

	/**
	 * Gets the size.
	 * 
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Gets the page sum.
	 * 
	 * @return the page sum
	 */
	public int getPageSum() {
		return (int) Math.ceil((double) recordSum / this.size);
	}

	/**
	 * Sets the size.
	 * 
	 * @param size
	 *            the size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Checks if is desc.
	 * 
	 * @return true, if is desc
	 */
	public boolean isDesc() {
		return desc;
	}

	/**
	 * Sets the desc.
	 * 
	 * @param desc
	 *            the desc
	 */
	public void setDesc(boolean desc) {
		this.desc = desc;
	}

	/**
	 * Checks if is next.
	 * 
	 * @return true, if is next
	 */
	public boolean isNext() {
		return this.no < this.getPageSum();
	}

	/**
	 * Checks if is previous.
	 * 
	 * @return true, if is previous
	 */
	public boolean isPrevious() {
		return this.no > 1;
	}

	/**
	 * Checks if is first.
	 * 
	 * @return true, if is first
	 */
	public boolean isFirst() {
		return this.no == 1;
	}

	/**
	 * Checks if is last.
	 * 
	 * @return true, if is last
	 */
	public boolean isLast() {
		return this.no == this.getPageSum();
	}

	/**
	 * Gets the order field name.
	 * 
	 * @return the order field name
	 */
	public String getOrderFieldName() {
		return orderFieldName;
	}

	/**
	 * Sets the order field name.
	 * 
	 * @param orderFieldName
	 *            the order field name
	 */
	public void setOrderFieldName(String orderFieldName) {
		this.orderFieldName = orderFieldName;
	}
}
