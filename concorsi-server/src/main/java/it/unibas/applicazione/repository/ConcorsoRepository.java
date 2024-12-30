package it.unibas.applicazione.repository;

import it.unibas.applicazione.modello.Concorso;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/***
 * Poiché avremo bisogno delle funzionalità CRUD di base sulle entità Utente , 
 * dobbiamo anche definire un'interfaccia UtenteRepository
 */

@Repository
public interface ConcorsoRepository extends CrudRepository<Concorso, Long> {
     List<Concorso> findByRegioneIgnoreCase(String regione);
}
