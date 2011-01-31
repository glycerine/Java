package eu.investuotojas.jmsquote.da;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="tickvolume")
public class TickVolume 
{

	@Id 
	@GeneratedValue
	@Column (name="id")
	private Integer id;
	@Column
	private Integer tickerId;
	@Column
	private Integer field;
	@Column
	private long timestamp;
	@Column
	private Integer size;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTickerId(Integer tickerId) {
		this.tickerId = tickerId;
	}

	public Integer getTickerId() {
		return tickerId;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setField(Integer field) {
		this.field = field;
	}

	public Integer getField() {
		return field;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getSize() {
		return size;
	}
}
