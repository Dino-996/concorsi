import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Concorso } from '../modello/concorso';

@Injectable({
  providedIn: 'root'
})

export class ConcorsoService {

  private baseURL: string = 'http://localhost:8080/concorsi';

  public constructor(private http: HttpClient) { }

  public getConcorsi(): Observable<Concorso[]> {
    return this.http.get<Concorso[]>(this.baseURL);
  }

  public getConcorsiPerRegione(regione:string): Observable<Concorso[]> {
    return this.http.get<Concorso[]>(`${this.baseURL}/regione/${regione}`);
  }

  public getConcorso(id:number): Observable<Concorso> {
    return this.http.get<Concorso>(`${this.baseURL}/${id}`);
  }
  
  public addConcorso(concorso: Concorso): Observable<void> {
    return this.http.post<void>(this.baseURL, concorso);
  }

}
