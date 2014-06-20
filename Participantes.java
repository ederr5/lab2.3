package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;
import play.db.ebean.*;

@Entity(name = "Participantes")
public class Participantes extends Model {
	
	
	 @Id
	 public Long id;
	
	@Required(message = "Campo Obrigatório")
	private String nome;
	
	@Required(message = "Campo Obrigatório. Insira no formato example@example.com")
	private String email;
	
	public static Model.Finder<Long,Participantes> find2 =
			new Model.Finder<Long,Participantes>(Long.class,Participantes.class);
	
	
	public Participantes() {}
	
	public static List<Participantes> all() {	
		  return find2.all();
		}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
