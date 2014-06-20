package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;
import models.*;

public class Application extends Controller {
	
	static Form<Hackaton> hackatonForm = Form.form(Hackaton.class);
	

	public static Result index() {
		  return redirect(routes.Application.hackatons());
		}
    
	public static Result hackatons() {
		  return ok(
		    views.html.index.render(Hackaton.all(), hackatonForm)
		  );
		}
      
	public static Result newHackaton() {
		  Form<Hackaton> filledForm = hackatonForm.bindFromRequest();
		  if(filledForm.hasErrors()) {
		    return badRequest(
		      views.html.index.render(Hackaton.all(), filledForm)
		    );
		  } else {
		    Hackaton.create(filledForm.get());
		    return redirect(routes.Application.hackatons());  
		  }
		}
	

      
	public static Result deleteHackaton(Long id) {
		  Hackaton.delete(id);
		  return redirect(routes.Application.hackatons());
		}
	
	
	public static Result updateHackaton(Long id) {
		Hackaton.update(id);
		return redirect(routes.Application.hackatons());
	}
	

}
