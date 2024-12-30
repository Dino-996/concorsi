package it.unibas.applicazione.modello;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString

/**
 * *
 * Per creare rapidamente un prototipo del livello di dominio della nostra
 * applicazione, definiamo una semplice classe di entità JPA, che sarà
 * responsabile della modellazione degli utenti
 */
@Entity
public class Concorso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codice;
    private String descrizione;
    private int numeroPosti;
    private String regione;
    private LocalDateTime dataOra;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "concorso_id")
    private final List<Domanda> listaDomande = new ArrayList<>();

    private void addDomanda(Domanda domanda) {
        this.listaDomande.add(domanda);
    }

    public Concorso(String codice, String descrizione, int numeroPosti, String regione, LocalDateTime dataOra) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.numeroPosti = numeroPosti;
        this.regione = regione;
        this.dataOra = dataOra;
    }
}
