package sr.bludots.assignments;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
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
  * Wat verwachten wij van u?
 * - gebruik overall for loops zonder int i = 0; i<x; i++, gebruik nieuwe constructies
 * - gebruik LocalDateTime formatter
 * - minimaliseer het aantal regels code (geen duplicaat code)
 * - gebruik logische functie namen
 * - probeer in 1 functie dingen te combineren, dus als je een 
 *  functie A en B die ongeveer hetzelfde doen, kun je dan een functie C maken
 * - probeer logische taken te isoleren in aparte functie
 * - probeer waar mogelijk a?b:c
 * - probeer zoveel constanten/enumeraties te gebruiken dus
 *   liever Month.MARCH dan 3 of liever VOLWASSSEN dan 18
 */

public class AtleetManager {

	public static ArrayList<SportAtleet> atletenList = new ArrayList<>();

	// zoek naar alle atleten die zwemmen en druk deze dan af
	public static void search(Sport searchSportType) {
		search("", searchSportType);
	}
//	Zoek naar alle individuele sporters   
	public static void searchIndividualOrTeam(boolean zoekIndividueel) {
		String title = zoekIndividueel?"Individuele sporters":"Teamsporters";
		if (zoekIndividueel) {
			title = "A";
		}
		else {
			title = "B";
		}
	
		System.out.println(title);
		for (SportAtleet atleet: atletenList)  {
			Sport sport = atleet.getSport();
			boolean sportIndividueel = sport.isIndividueel();
			if (zoekIndividueel == sportIndividueel) {
				System.out.println("Name: "+atleet.getVoornaam()
						+" "+atleet.getAchternaam()+ 
						" Sport: " + sport.toString());
			} 
		}
	}
	
	
	
//	Druk af hoeveel sporters er zijn die geboren zijn in 2000-2002  
	public static void printAthletesBetween2000En2002(ArrayList<SportAtleet> atletenList) {
		int athletesBetween2000En2002 = 0;
		 for (SportAtleet atleet: atletenList){
			if(atleet.getGeboorteDatum().getYear() >=2000 && atleet.getGeboorteDatum().getYear()<=2002) {
				athletesBetween2000En2002++;
			}
			System.out.println("Total athletes born between 2000 en 2002: " + athletesBetween2000En2002);
		}
		
	}
	public static void sportmenBornInMarch(ArrayList<SportAtleet> atletenList) {
		int marchBornPlayers = 0;
		for (SportAtleet atleet: atletenList) {
			if (atleet.getGeboorteDatum().getMonth().equals(Month.MARCH)) {
				marchBornPlayers++;
			}
			System.out.println("Aantal spelers geboren in maart: " + marchBornPlayers);
		}
	}
	// Return a string representation of a date
		public static String getEuroDate(LocalDate date) {
			int year = date.getYear();
			int month = date.getMonthValue();
			int day = date.getDayOfMonth();
			String s = day + "-" + month + "-" + year;
			
			DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd-MM-yyyy HH:mm ")
	                .toFormatter();
			s = formatter.format(date);
			return s;
		}
	
	// zoek naar alle atleten die jair heten en zwemmen en druk deze dan af. Als firstName null is (negeer deze) 
	public static void search(String firstName, Sport searchSportType) {
        for (SportAtleet atleet: atletenList)
			if (atleet.getSport().equals(searchSportType)) {
				String voornaam = atleet.getVoornaam();
				if (firstName.equals("") || firstName.equals(voornaam)) {	
					atleet.showAtleet();
				}
			}
		}
//	Druk af hoeveel teamsporters er in de lijst zitten 
	public static void printTotalTeamSporters(ArrayList<SportAtleet> atletenList) {
		int aantalTeamSporters = 0;
		 for (SportAtleet atleet: atletenList){
			if(!atleet.getSport().isIndividueel()) {
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
//	    printAthletesBetween2000En2002(atletenList);
		
		// of atleten die zwemmen
//		search("", Sport.ZWEMMEN);

		// zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
//		search("Jair", Sport.ZWEMMEN);
		
		// zoek naar alle individuele sporters
//		searchIndividualOrTeam(false);
		
//		Druk af hoeveel teamsporters er in de lijst zitten
		printTotalTeamSporters(atletenList);
		
//		Druk af hoeveel sporters er zijn die jarig zijn in Maart
//		sportmenBornInMarch(atletenList);

	}
	
	public static void fillAtletenArray() {
		
		int minDay = (int) LocalDate.of(1990, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2005, 12, 31).toEpochDay();
		
		for (int i = 0; i < 50; i++) {
			Random random = new Random();

			String[] voornamen = { "Jair", "Lisa", "Roy", "Bob", "Jenny" };
			int chooseVoornaam = random.nextInt(voornamen.length);

			String[] achternamen = { "ling", "Ben", "Bro", "Lenny", "Rob" };
			int chooseAchternaam = random.nextInt(achternamen.length);

			int chooseSport = random.nextInt(Sport.values().length);
					
//			int dag = random.nextInt(28) + 1;
//		int maand = random.nextInt(12) + 1;
			
//			String[] chooseMaand = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
//					"October", "November", "December" };
//			int maand = random.nextInt(chooseMaand.length)+1;
			
//			int jaar = random.nextInt(2003 - 1990) + 1990;
			
			long randomDay = minDay + random.nextInt(maxDay - minDay); 
			LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
		
			SportAtleet atleet = new SportAtleet(voornamen[chooseVoornaam], achternamen[chooseAchternaam], 
					Sport.values()[chooseSport], randomBirthDate);

			atletenList.add(atleet);

		}
	
	}

}
