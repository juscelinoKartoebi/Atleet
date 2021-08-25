package sr.bludots.assignments;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import sr.bludots.assignments.SportAtleet.Sport;

/*
 * Assignment:
 * 
 * 1) Zorg ervoor dat de geboortedatum willekeurig is tussen 2 data      //
 * bijv atleten moeten geboren zijn tussen 1990 - 2003
 * 
 * 2) Zoek naar alle individuele sporters                               //
 * 
 * 3) Druk af hoeveel teamsporters er in de lijst zitten               //
 * 
 * 4) Druk af hoeveel sporters er zijn die jarig zijn in Maart
 *
 * 5) Druk af hoeveel sporters er zijn die geboren zijn in 2000-2002  //
 * 
 * 6) Druk de geboortedatum af in de Europese notatie  1 January 2002  (en niet de Amerikaanse 2002-01-01)
 */


public class AtleetManager {

	public static ArrayList<SportAtleet> atletenList = new ArrayList<>();

	// zoek naar alle atleten die zwemmen en druk deze dan af
	public static void search(Sport searchSportType) {
		search("", searchSportType);
	}
//	Zoek naar alle individuele sporters   
	public static void search (boolean isIndividueel) {
		for (int i = 0; i < atletenList.size(); i++){
			SportAtleet atleet = atletenList.get(i);
			if(atleet.getSport().isIndividueel()) {
				atleet.showAtleet();
			}
			
		}
	}
//	Druk af hoeveel sporters er zijn die geboren zijn in 2000-2002  
	public static void printAthletesBetween2000En2002(ArrayList<SportAtleet> atletenList) {
		int athletesBetween2000En2002 = 0;
		for (int i = 0; i < atletenList.size(); i++) {
			if(atletenList.get(i).getGeboorteDatum().getYear() >=2000 && atletenList.get(i).getGeboorteDatum().getYear()<=2002) {
				athletesBetween2000En2002++;
			}
			System.out.println("Total athletes born between 2000 en 2002: " + athletesBetween2000En2002);
		}
		
	}
	// zoek naar alle atleten die jair heten en zwemmen en druk deze dan af. Als firstName null is (negeer deze) 
	public static void search(String firstName, Sport searchSportType) {

		for (int i = 0; i < atletenList.size(); i++) {
			SportAtleet atleet = atletenList.get(i);
			if (atleet.getSport().equals(searchSportType)) {
				String voornaam = atleet.getVoornaam();
				if (firstName.equals("") || firstName.equals(voornaam)) {	
					atleet.showAtleet();
				}
			}
		}
	}
//	Druk af hoeveel teamsporters er in de lijst zitten 
	public static void printTotalTeamSporters(ArrayList<SportAtleet> atletenList) {
		int aantalTeamSporters = 0;
		for(int i = 0; i < atletenList.size(); i++) {
			if(!atletenList.get(i).getSport().isIndividueel()) {
				aantalTeamSporters++;
			}
		}
		System.out.println("Total teamsporters in de list: " + aantalTeamSporters + " players.");
	}
	
	public static void main(String args[]) {

		fillAtletenArray();
		
		// zoek naar alle atleten die zwemmen en druk deze dan af
//		search(Sport.ZWEMMEN);
		
		// Druk af hoeveel sporters er zijn die geboren zijn in 2000-2002
//	    searchAthletesBetween2000En2002(atletenList);
		
		// of atleten die zwemmen
//		search("", Sport.ZWEMMEN);

		// zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
//		search("Jair", Sport.ZWEMMEN);
		
		// Druk af hoeveel sporters er zijn die jarig zijn in Maart
//		search(); NOG NIET KUNNEN DOEN
		
		// zoek naar alle individuele sporters
		search(true);
		
//		Druk af hoeveel teamsporters er in de lijst zitten
//		totalTeamSporters(atletenList);

		LocalDate startDatum = LocalDate.of(1999, 1, 1);
		LocalDate endDatum = LocalDate.of(2003,12, 31);
		Duration duration = Duration.between(startDatum.atStartOfDay(), endDatum.atStartOfDay());
		System.err.println(" verschil is " + duration.toDays());
		LocalDate nextDate = startDatum.plusDays(1);
		System.err.println("D1=" + startDatum + ", D2=" + nextDate);
		System.err.println("Maand van D1=" + startDatum.getMonthValue() + ", maand=" + startDatum.getMonth());
		System.err.println("Jaar van D1=" + startDatum.getYear());
	}
	
	public static void fillAtletenArray() {
		for (int i = 0; i < 50; i++) {
			Random random = new Random();

			String[] voornamen = { "Jair", "Lisa", "Roy", "Bob", "Jenny" };
			int chooseVoornaam = random.nextInt(voornamen.length);

			String[] achternamen = { "ling", "Ben", "Bro", "Lenny", "Rob" };
			int chooseAchternaam = random.nextInt(achternamen.length);

			int chooseSport = random.nextInt(Sport.values().length);
					
			int dag = random.nextInt(28) + 1;
		int maand = random.nextInt(12) + 1;
			
//			String[] chooseMaand = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
//					"October", "November", "December" };
//			int maand = random.nextInt(chooseMaand.length)+1;
			
			int jaar = random.nextInt(2003 - 1990) + 1990;
		
			SportAtleet atleet = new SportAtleet(voornamen[chooseVoornaam], achternamen[chooseAchternaam], 
					Sport.values()[chooseSport], LocalDate.of(jaar, maand, dag));

			atletenList.add(atleet);

		}
	
	}

}
