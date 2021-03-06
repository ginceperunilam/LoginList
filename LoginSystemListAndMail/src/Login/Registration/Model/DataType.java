package Login.Registration.Model;
// Generated Mar 21, 2020 5:51:12 PM by Hibernate Tools 5.2.3.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DataType generated by hbm2java
 */
@Entity
@Table(name = "DATA_TYPE")
public class DataType implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String shortCode;
	private Long length;
	private String format;

	public DataType() 
	{
	}

	public DataType(String name, String shortCode) 
	{
		this.name = name;
		this.shortCode = shortCode;
	}

	public DataType(String name, String shortCode, Long length, String format) 
	{
		this.name = name;
		this.shortCode = shortCode;
		this.length = length;
		this.format = format;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() 
	{
		return this.id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() 
	{
		return this.name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	@Column(name = "SHORT_CODE", nullable = false, length = 1)
	public String getShortCode() 
	{
		return this.shortCode;
	}

	public void setShortCode(String shortCode) 
	{
		this.shortCode = shortCode;
	}

	@Column(name = "LENGTH")
	public Long getLength() 
	{
		return this.length;
	}

	public void setLength(Long length) 
	{
		this.length = length;
	}

	@Column(name = "FORMAT", length = 50)
	public String getFormat() 
	{
		return this.format;
	}

	public void setFormat(String format) 
	{
		this.format = format;
	}
}
