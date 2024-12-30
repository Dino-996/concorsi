import { Component, OnInit } from '@angular/core';
import { Concorso } from '../../modello/concorso';
import { ConcorsoService } from '../../servizi/concorso.service';
import { DatePipe } from '@angular/common';
import { ListaDomandeComponent } from '../lista-domande/lista-domande.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-lista-concorsi',
  standalone: true,
  imports: [
    DatePipe,
    ListaDomandeComponent,
    FormsModule
  ],
  templateUrl: './lista-concorsi.component.html',
  styleUrl: './lista-concorsi.component.css'
})

export class ListaConcorsiComponent implements OnInit {

  public concorsi: Concorso[] = [];
  public concorsoSelezionato: Concorso | null = null;
  public criterioRicerca: string = "";
  public ordinamento: string = "data crescente";

  public constructor(private concorsoService: ConcorsoService) { }

  public ngOnInit(): void {
    this.caricaConcorsi();
  }

  private caricaConcorsi(): void {
    this.concorsoService.getConcorsi().subscribe((data) => {
      this.concorsi = data;
      this.onOrdinamento(this.concorsi);
    });
  }

  public selezionaConcorso(id: number): void {
    this.concorsoSelezionato = null;
    for (let concorso of this.concorsi) {
      if (concorso.id === id) {
        this.concorsoSelezionato = concorso;
      }
    }
  }

  public cercaPerRegione(): void {
    this.caricaConcorsi();
    if(!this.criterioRicerca?.trim()) {
      return;
    }
    this.concorsoService.getConcorsiPerRegione(this.criterioRicerca).subscribe(data => {
      this.concorsi = data;
      this.onOrdinamento(this.concorsi);
    });
  }

  
  public chiudiOverlay(): void {
    this.concorsoSelezionato = null;
  }

  private onOrdinamento(altroConcorso: Concorso[]): void {
    if (this.ordinamento === "posti decrescente") {
      altroConcorso.sort((a, b) => { return b.numeroPosti - a.numeroPosti });
    }
    if (this.ordinamento === "data crescente") {
      altroConcorso.sort((a, b) => {
        const dateA = a.dataOra instanceof Date ? a.dataOra : new Date(a.dataOra);
        const dateB = b.dataOra instanceof Date ? b.dataOra : new Date(b.dataOra);
        return dateA.getTime() - dateB.getTime();
      });
    }
  }

}