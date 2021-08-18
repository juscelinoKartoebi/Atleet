package sr.bludots.assignments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import sr.bludots.assignments.Atleet.Sport;

public class App {

	public static void main(String args[]) {

		ArrayList<Atleet> Atleten = new ArrayList<>(); // Maak een lijst van 50 atleten.

		for (int i = 0; i < 50; i++) {
			Random random = new Random();

			String[] voornamen = { "Jair", "Lisa", "Roy", "Bob", "Jenny" };
			int chooseVoornaam = random.nextInt(5);

			String[] achternamen = { "ling", "Ben", "Bro", "Lenny", "Rob" };
			int chooseAchternaam = random.nextInt(5);

			Sport[] sports = { Sport.BAANWIELRENNEN, Sport.ZWEMMEN, Sport.VOETBALLEN, Sport.BOKSEN, Sport.ATLETIEK };
			int chooseSport = random.nextInt(5);

			LocalDate[] geboorteDatum = { LocalDate.of(1999, 9, 1), LocalDate.of(2006, 9, 1), LocalDate.of(2004, 9, 1),
					LocalDate.of(2003, 9, 1), LocalDate.of(2004, 9, 1) };
			int choosegeboorteDatum = random.nextInt(5);

			Atleet atleet = new Atleet(voornamen[chooseVoornaam], achternamen[chooseAchternaam], sports[chooseSport],
					geboorteDatum[choosegeboorteDatum]);

//			LocalDate.of(birthdate.randomYear(), birthdate.randomMonth(), birthdate.randomDay())

			Atleten.add(atleet);

		}
		// zoek naar alle atleten die zwemmen en druk deze dan af
		Atleet.searchSportType(Atleten, Sport.ZWEMMEN);

		// zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
		Atleet.searchFirstNameAndSportType(Atleten, "Jair", Sport.ZWEMMEN);

	}

}
