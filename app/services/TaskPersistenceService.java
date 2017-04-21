package services;

import jpa.Task1;

import java.util.List;





public interface TaskPersistenceService {
    void saveTask(Task1 t);

    List<Task1> fetchAllTasks();
    
     }
                                           
