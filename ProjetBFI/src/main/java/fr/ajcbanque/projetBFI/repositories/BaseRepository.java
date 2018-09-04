package fr.ajcbanque.projetBFI.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseRepository {
    @PersistenceContext
    protected EntityManager em;

    protected BaseRepository() {
	//
    }
}
