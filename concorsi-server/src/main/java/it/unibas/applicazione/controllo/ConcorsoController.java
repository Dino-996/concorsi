package it.unibas.applicazione.controllo;

import it.unibas.applicazione.modello.Concorso;
import it.unibas.applicazione.modello.Domanda;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import it.unibas.applicazione.repository.ConcorsoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor

/**
 * *
 * Implementiamo la REST API che in questo caso, è solo un semplice controller
 * REST
 */
@RestController

/**
 * *
 * L'annotazione @CrossOrigin abilita la condivisione delle risorse Cross-Origin
 * (CORS) sul server. Necessario poiché stiamo distribuendo il nostro frontend
 * Angular su http://localhost:4200 e il nostro backend Boot su
 * http://localhost:8080 , altrimenti il ​​browser negherebbe le richieste
 * dall'uno all'altro.
 */
@CrossOrigin(origins = "http://localhost:4200")
public class ConcorsoController {

    private final ConcorsoRepository concorsoRepository;

    @GetMapping("/concorsi")
    public List<Concorso> getConcorsi() {
        return (List<Concorso>) concorsoRepository.findAll();
    }

    @GetMapping("/concorsi/regione/{regione}")
    public ResponseEntity<Object> getConcorsiByRegione(@PathVariable String regione) {
        if (regione == null || regione.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La regione non può essere vuota.");
        }
        List<Concorso> concorsi = concorsoRepository.findByRegioneIgnoreCase(regione);
        return ResponseEntity.ok(concorsi);
    }

    @GetMapping("/concorsi/{id}")
    public Concorso getConcorsi(@PathVariable Long id) {
        return concorsoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Concorso non trovato"));
    }

    @PostMapping("/concorsi")
    public void addConcorsi(@RequestBody Concorso concorso) {
        concorsoRepository.save(concorso);
    }

    // Domande
    @GetMapping("/concorsi/{id}/domande")
    public List<Domanda> getDomandeByConcorso(@PathVariable Long id) {
        Concorso concorso = concorsoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Concorso non trovato con ID: " + id));
        return concorso.getListaDomande();
    }

    @PostMapping("/concorsi/{id}/domande")
    public void addDomanda(@PathVariable Long id, @RequestBody Domanda nuovaDomanda) {
        Concorso concorso = concorsoRepository.findById(id).get();
        concorso.getListaDomande().add(nuovaDomanda);
        concorsoRepository.save(concorso);
    }
}
