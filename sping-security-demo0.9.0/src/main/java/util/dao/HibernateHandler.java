package util.dao;

import org.hibernate.Criteria;

/**
 * 自定义复杂查询的回调接口。
 * 
 * 使用hibernate提供的criteria api。
 * 
 * @author Marshal Wu <a
 *         href="mailto:marshal.wu@gmail.com">marshal.wu@gmail.com</a>
 * 
 */
public interface HibernateHandler {
	public void setCriteria(Criteria criteria);
}
