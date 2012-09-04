package tasystem.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="title")
public class Title implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int title_id;
	
	@Column
	private String title_name;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Set<Requisition> reqList = new HashSet<Requisition>();
	
	public Title() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTitle_id() {
		return title_id;
	}

	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}

	public String getName() {
		return title_name;
	}

	public void setTitle_name(String name) {
		this.title_name = name;
	}


	public String getTitle_name() {
		return title_name;
	}

	public Set<Requisition> getReqList() {
		return reqList;
	}

	public void setReqList(Set<Requisition> reqList) {
		this.reqList = reqList;
	}
	
	
}
