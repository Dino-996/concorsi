import { Component } from '@angular/core';
import { ListaConcorsiComponent } from './componenti/lista-concorsi/lista-concorsi.component';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    ListaConcorsiComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'utenti-client';
}
