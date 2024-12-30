import { Component, EventEmitter, Input, Output, ViewChild, viewChild } from '@angular/core';
import { Concorso } from '../../modello/concorso';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-lista-domande',
  standalone: true,
  imports: [DatePipe],
  templateUrl: './lista-domande.component.html',
  styleUrl: './lista-domande.component.css'
})

export class ListaDomandeComponent {
  
  @Input() concorsoSelezionato: Concorso | null = null;
  @Output() modifica = new EventEmitter<void>();

  public notificaModifica() {  
    this.modifica.emit();
  }

}
