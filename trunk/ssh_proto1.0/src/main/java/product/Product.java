package product;

import java.io.Serializable;
import java.util.Date;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

@Searchable
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SearchableId
	private Long id;

	@SearchableProperty(name="name")
	private String name;

	private float price;

	@SearchableProperty(name="introduction")
	private String introduction;

	private Date createTime;

	private String vender;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getVender() {
		return vender;
	}

	public void setVender(String vender) {
		this.vender = vender;
	}

}
