package eu.investuotojas.jmsquote.da;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="tickprice")
public class TickPrice 
{
	@Id 
	@GeneratedValue
	@Column (name="id")
	private Integer id;
	
	@Column (name="tickerid")
	private Integer tickerId;
	@Column
	private Double price;
	@Column
	private Integer field;
	
	@Column (name="ts")
	private long timestamp;
	
	
	public void setTickerId(Integer tickerId) {
		this.tickerId = tickerId;
	}

	public Integer getTickerId() {
		return tickerId;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setField(Integer field) {
		this.field = field;
	}

	public Integer getField() {
		return field;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
}
