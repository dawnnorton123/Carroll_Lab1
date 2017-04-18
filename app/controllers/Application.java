package controllers;

import jpa.Task1;
import models.TaskForm;

import services.TaskPersistenceService;

import views.html.index;
import views.html.dawnsPage;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Named
public class Application extends Controller {
	
	 private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Inject
    private TaskPersistenceService taskPersist;

    public Result index() {
        return ok(index.render("Dawn's Page!!", Form.form(TaskForm.class)));
    }

    public Result addTask() {
        Form<TaskForm> form = Form.form(TaskForm.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(index.render("Dawn's Page!!", form));
        }

        Task1 task = new Task1();
        task.setContents(form.get().getContents());
        taskPersist.saveTask(task);
        return redirect(routes.Application.index());
    }

    public Result getTasks() {
        List<Task1> tasks = taskPersist.fetchAllTasks();
        return ok(play.libs.Json.toJson(tasks));
    }
    

    public Result dawnsPage() {
    	log.warn("Entering Dawns Page!!");
        return ok(dawnsPage.render("Dawn's Page!!"));
        
        
    }


  
}