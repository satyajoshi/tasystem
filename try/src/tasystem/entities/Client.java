package tasystem.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="client")
public class Client implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int client_id;
	
	@Column
	private String client_name;
	
	@Column
	private String client_manager_name;
	
	@Column 
	private String client_manager_email;
	
	@Column
	private int client_manager_phone;
	
	@OneToMany(targetEntity=Requisition.class,fetch=FetchType.EAGER,mappedBy="client")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Set<Requisition> reqList = new HashSet<Requisition>();

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getClient_manager_name() {
		return client_manager_name;
	}

	public void setClient_manager_name(String client_manager_name) {
		this.client_manager_name = client_manager_name;
	}

	public String getClient_manager_email() {
		return client_manager_email;
	}

	public void setClient_manager_email(String client_manager_email) {
		this.client_manager_email = client_manager_email;
	}

	public int getClient_manager_phone() {
		return client_manager_phone;
	}

	public void setClient_manager_phone(int client_manager_phone) {
		this.client_manager_phone = client_manager_phone;
	}

	public Set<Requisition> getReqList() {
		return reqList;
	}

	public void setReqList(Set<Requisition> reqList) {
		this.reqList = reqList;
	}
	
	
}
