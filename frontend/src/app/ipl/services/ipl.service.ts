import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Team } from "../types/Team";
import { Cricketer } from "../types/Cricketer";
import { Match } from "../types/Match";
import { Vote } from "../types/Vote";
import { TicketBooking } from "../types/TicketBooking";

@Injectable({
  providedIn: "root",
})
export class IplService {
  private baseUrl = `${environment.apiUrl}`;

  constructor(private http: HttpClient) {}

  
  addTeam(team: Team): Observable<Team> {
    return new Observable<Team>();
  }

  updateTeam(team: Team): Observable<Team> {
    return new Observable<Team>();
  }

  deleteTeam(teamId: number): Observable<any> {
    return new Observable<any>();
  }

  getAllTeams(): Observable<Team[]> {
    return new Observable<Team[]>();
  }

  getTeamById(teamId: number): Observable<Team> {
     return new Observable<Team>();
  }


  addCricketer(cricketer: Cricketer): Observable<Cricketer> {
    return new Observable<Cricketer>();
  }

  updateCricketer(cricketer: Cricketer): Observable<Cricketer> {
    return new Observable<Cricketer>();
  }

  deleteCricketer(cricketerId: number): Observable<any> {
    return new Observable<any>();
  }

  getAllCricketers(): Observable<Cricketer[]> {
    return new Observable<Cricketer[]>();
  }

  getCricketerById(cricketerId: number): Observable<Cricketer> {
     return new Observable<Cricketer>();
  }

  getCricketersByTeam(teamId: number): Observable<Cricketer[]> {
    return new Observable<Cricketer[]>();
  }

  addMatch(match: Match): Observable<Match> {
    return new Observable<Match>();
  }

  updateMatch(match: Match): Observable<Match> {
    return new Observable<Match>();
  }

  deleteMatch(matchId: number): Observable<any> {
    return new Observable<any>();
  }

  getAllMatches(): Observable<Match[]> {
    return new Observable<Match[]>();
  }

  getMatchById(matchId: number): Observable<Match> {
     return new Observable<Match>();
  }

  getAllMatchesByStatus(status: string): Observable<Team[]> {
    return new Observable<Team[]>();
  }


  getAllVotes(): Observable<Vote[]> {
    return new Observable<Vote[]>();
  }
  
  createVote(vote: Vote): Observable<Vote> {
    return new Observable<Vote>();
  }
  
  getVotesCountOfAllCategories(): Observable<Map<string, number>> {
    return new Observable<Map<string, number>>();
  }


  getAllTicketBookings(): Observable<TicketBooking[]> {
    return new Observable<TicketBooking[]>();
  }
    
  createBooking(ticketBooking: TicketBooking): Observable<TicketBooking> {
    return new Observable<TicketBooking>();
  }
    
  cancelBooking(bookingId: number): Observable<any> {
    return new Observable<any>();
  }

  getBookingsByUserEmail(email: string): Observable<TicketBooking[]> {
    return new Observable<TicketBooking[]>();
  }
}