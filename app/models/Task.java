package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Task extends Model implements Comparable{

  @Id
  public Long id;
  
  @Required
  public String label;
  
  @Required
  public String priority;
  
  @Required
  public String week;
  
  private boolean isDone = false;
  
  public static Finder<Long,Task> find = new Finder(
    Long.class, Task.class
  );
  
  public static List<Task> all() {	
	  return find.all();
	}

	public static void create(Task task) {
	  task.save();
	}

	public static void delete(Long id) {
	  find.ref(id).delete();
	}
	
	public static void update(Long id) {
		Task tmp = new Task();

		tmp.setDone(true);
		tmp.setLabel(find.ref(id).getLabel());
		tmp.setPriority(find.ref(id).getPriority());
		tmp.setWeek(find.ref(id).getWeek());

		delete(id);
		create(tmp);

	}
	
	//get's and set's
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
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

	@Override
	public int compareTo(Object arg0) {

		return (this.getPriority().compareTo(((Task) arg0).getPriority()));
	}

}