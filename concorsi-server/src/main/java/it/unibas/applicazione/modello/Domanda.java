package it.unibas.applicazione.modello;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

@Entity
public class Domanda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codiceFiscale;
    private String sesso;
    private LocalDate dataDomanda;

    public Domanda(String codiceFiscale, String sesso, LocalDate dataDomanda) {
        this.codiceFiscale = codiceFiscale;
        this.sesso = sesso;
        this.dataDomanda = dataDomanda;
    }
}
