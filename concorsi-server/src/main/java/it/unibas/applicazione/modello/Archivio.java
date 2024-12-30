package it.unibas.applicazione.modello;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter

public class Archivio {

    private final List<Concorso> listaConcorsi = new ArrayList<>();

    public void addConcorso(Concorso concorso) {
        this.listaConcorsi.add(concorso);
    }

}
