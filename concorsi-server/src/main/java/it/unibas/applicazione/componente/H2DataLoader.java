package it.unibas.applicazione.componente;

import it.unibas.applicazione.modello.Archivio;
import it.unibas.applicazione.modello.Concorso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import it.unibas.applicazione.repository.ConcorsoRepository;

@Component
public class H2DataLoader implements CommandLineRunner {

    @Autowired
    private ConcorsoRepository utenteRepository;

    @Override
    public void run(String... args) throws Exception {
        ArchivioMock mock = new ArchivioMock();
        Archivio listaConcorsi = mock.caricaArchivio();
        for (Concorso concorso : listaConcorsi.getListaConcorsi()) {
            utenteRepository.save(concorso);
        }
    }
}
