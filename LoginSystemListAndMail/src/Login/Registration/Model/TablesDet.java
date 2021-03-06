package Login.Registration.Model;
// Generated Mar 21, 2020 5:51:12 PM by Hibernate Tools 5.2.3.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TablesDet generated by hbm2java
 */
@Entity
@Table(name = "TABLES_DET")
public class TablesDet implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long tablesId;
	private String name;
	private String displayName;
	private String showInList;
	private String showInDetail;
	private String dataType;
	private Long   listOrder;
	
	private Tables tables;

	public TablesDet() 
	{
	}

	public TablesDet(Long tables, String name, String showInList, String showInDetail) 
	{
		this.tablesId = tables;
		this.name = name;
		this.showInList = showInList;
		this.showInDetail = showInDetail;
	}

	public TablesDet(Long tables, String name, String displayName, String showInList, String showInDetail,
			String dataType) 
	{
		this.tablesId = tables;
		this.name = name;
		this.displayName = displayName;
		this.showInList = showInList;
		this.showInDetail = showInDetail;
		this.dataType = dataType;
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

	@Column(name = "TABLES_ID", nullable = false, insertable=false, updatable=false)
	public Long getTablesId() 
	{
		return this.tablesId;
	}

	public void setTablesId(Long tables) 
	{
		this.tablesId = tables;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() 
	{
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DISPLAY_NAME", length = 100)
	public String getDisplayName() 
	{
		return this.displayName;
	}

	public void setDisplayName(String displayName) 
	{
		this.displayName = displayName;
	}

	@Column(name = "SHOW_IN_LIST", nullable = false, length = 1)
	public String getShowInList() {
		return this.showInList;
	}

	public void setShowInList(String showInList) {
		this.showInList = showInList;
	}

	@Column(name = "SHOW_IN_DETAIL", nullable = false, length = 1)
	public String getShowInDetail() 
	{
		return this.showInDetail;
	}

	public void setShowInDetail(String showInDetail) 
	{
		this.showInDetail = showInDetail;
	}

	@Column(name = "DATA_TYPE", length = 1)
	public String getDataType() 
	{
		return this.dataType;
	}

	public void setDataType(String dataType) 
	{
		this.dataType = dataType;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TABLE_ID", nullable = false)
	public Tables getTables() 
	{
		return this.tables;
	}

	public void setTables(Tables tables) 
	{
		this.tables = tables;
	}

	@Column(name = "LIST_ORDER")
	public Long getListOrder() {
		return listOrder;
	}

	public void setListOrder(Long listOrder) {
		this.listOrder = listOrder;
	}
}
