package fr.ajcbanque.projetBFI.repositories;

import javax.persistence.*;

public abstract class BaseRepository {

    @PersistenceContext
    protected EntityManager em;

    protected BaseRepository() {
	//
    }
}
