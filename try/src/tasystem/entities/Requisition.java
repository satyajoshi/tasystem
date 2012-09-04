package tasystem.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;





@Entity
@Table(name="requisition")
public class Requisition implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int req_id;
	@ManyToOne(targetEntity=Client.class, fetch=FetchType.EAGER)
	@JoinColumn(name="client_id")
	private Client client;
	@Column
	private Team_lead team_lead = new Team_lead();
	@Column
	private String team_name;
	@Column
	private String pos_description;
	@Column
	private String start_date;
	@Column
	private String end_date;
	@Column
	private String location;
	@Column
	private int no_of_position;
	@Column
	private int rate;
	@ManyToOne(fetch=FetchType.EAGER)
	private Title title;
	@OneToMany(targetEntity = Position.class, fetch=FetchType.EAGER,mappedBy = "requisition")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Set<Position> posList = new HashSet<Position>();
	
	public Requisition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Team_lead getTeam_lead() {
		return team_lead;
	}

	public void setTeam_lead(Team_lead team_lead) {
		this.team_lead = team_lead;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	
	public Set<Position> getPosList() {
		return this.posList;
	}

	public void setPosList(Set<Position> posList) {
		this.posList = posList;
	}

	public String getPos_descritption() {
		return pos_description;
	}

	public void setPos_descritption(String pos_descritption) {
		this.pos_description = pos_descritption;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}



	public int getNo_of_position() {
		return no_of_position;
	}

	public void setNo_of_position(int no_of_position) {
		this.no_of_position = no_of_position;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getPos_description() {
		return pos_description;
	}

	public void setPos_description(String pos_description) {
		this.pos_description = pos_description;
	}
	
	
	
}
