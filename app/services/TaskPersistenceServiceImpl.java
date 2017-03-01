package services;


import java.util.List;

import jpa.Task1;



import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
public class TaskPersistenceServiceImpl implements TaskPersistenceService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void saveTask(Task1 task) {
    	 em.persist(task);
    }

    @Override
    public List<Task1> fetchAllTasks() {
        return em.createQuery("from Task1", Task1.class).getResultList();
    }
}
