package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity(name = "Hackaton")
public class Hackaton extends Model{

  @Id
  public Long id;
  
  @Required(message = "Campo Obrigatório")
  public String label;
  
  @Required(message = "Campo Obrigatório")
  public String description;
  
  @Required(message = "Campo Obrigatório")
  public String date;
  
  @Required(message = "Campo Obrigatório")
  public String type;
  
  public static List<Participantes> participantes;
  
  private boolean isDone = false;
  
  public static Finder<Long,Hackaton> find = new Finder(
    Long.class, Hackaton.class
  );
  
  public static List<Hackaton> all() {	
	  return find.all();
	}

	public static void create(Hackaton hackaton) {
	  hackaton.save();
	  
	}

	public static void delete(Long id) {
	  find.ref(id).delete();
	}
	
	public static void update(Long id) {
		Hackaton tmp = new Hackaton();

		tmp.setDone(true);
		tmp.setLabel(find.ref(id).getLabel());
		tmp.setDescription(find.ref(id).getDescription());
		tmp.setDate(find.ref(id).getDate());
		tmp.setType(find.ref(id).getType());

		delete(id);
		create(tmp);

	}
	public static void addparticipantes(Participantes participante){
		participantes.add(participante);
	}
	
	/*public static void list(String type){
		for(int i = 0; i < find.all().value(); i++){
			if(find.ref(i).type == type){
				System.out.println(find.ref(id).getLabel());
			}
		}
	}*/
	
	
	//get's and set's
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public Long getId() {
		return id;
	}


}