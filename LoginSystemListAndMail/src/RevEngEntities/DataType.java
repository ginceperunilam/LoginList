//package src.RevEngEntities;
//// Generated Mar 21, 2020 5:51:12 PM by Hibernate Tools 5.2.3.Final
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import static javax.persistence.GenerationType.IDENTITY;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
///**
// * DataType generated by hbm2java
// */
//@Entity
//@Table(name = "data_type", catalog = "sql_db")
//public class DataType implements java.io.Serializable {
//
//	private Integer id;
//	private String name;
//	private String shortCode;
//	private Integer length;
//	private String format;
//
//	public DataType() {
//	}
//
//	public DataType(String name, String shortCode) {
//		this.name = name;
//		this.shortCode = shortCode;
//	}
//
//	public DataType(String name, String shortCode, Integer length, String format) {
//		this.name = name;
//		this.shortCode = shortCode;
//		this.length = length;
//		this.format = format;
//	}
//
//	@Id
//	@GeneratedValue(strategy = IDENTITY)
//
//	@Column(name = "ID", unique = true, nullable = false)
//	public Integer getId() {
//		return this.id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	@Column(name = "NAME", nullable = false, length = 100)
//	public String getName() {
//		return this.name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	@Column(name = "SHORT_CODE", nullable = false, length = 1)
//	public String getShortCode() {
//		return this.shortCode;
//	}
//
//	public void setShortCode(String shortCode) {
//		this.shortCode = shortCode;
//	}
//
//	@Column(name = "LENGTH")
//	public Integer getLength() {
//		return this.length;
//	}
//
//	public void setLength(Integer length) {
//		this.length = length;
//	}
//
//	@Column(name = "FORMAT", length = 50)
//	public String getFormat() {
//		return this.format;
//	}
//
//	public void setFormat(String format) {
//		this.format = format;
//	}
//
//}
