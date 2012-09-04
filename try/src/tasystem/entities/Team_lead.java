package tasystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="team_lead")
public class Team_lead implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int team_lead_id;

	public Team_lead() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTeam_lead_id() {
		return team_lead_id;
	}

	public void setTeam_lead_id(int team_lead_id) {
		this.team_lead_id = team_lead_id;
	}
	
	
}
