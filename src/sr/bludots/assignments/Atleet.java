package sr.bludots.assignments;

import java.time.LocalDate;
import java.util.ArrayList;


//
//Assignment 1: Maak een lijst van 50 atleten.
//Vul ze steeds met andere sporten, dus bijv een aantal boksers, voetballers etc ec
//Maak deze ook aan met een variabel geboortejaar (tussen 1990-2005))

//- zoek naar alle atleten die zwemmen en druk deze dan af
//- zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
//vul de 
//(*) zoek naar alle atleten die jonger zijn dan 20 jaar 

public class Atleet {

	public enum Sport {
		BAANWIELRENNEN, ZWEMMEN, VOETBALLEN, BOKSEN, ATLETIEK
	};

	private String voornaam;
	private String Achternaam;
	private Sport sport;
	private LocalDate geboorteDatum;
	public ArrayList<Atleet> arrayList = new ArrayList<>();

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return Achternaam;
	}

	public void setAchternaam(String achternaam) {
		Achternaam = achternaam;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}

	public void setGeboorteDatum(LocalDate geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}

	public Atleet(String voornaam, String achternaam, Sport sport, LocalDate geboorteDatum) {
		this.voornaam = voornaam;
		Achternaam = achternaam;
		this.sport = sport;
		this.geboorteDatum = geboorteDatum;

	}

	// zoek naar alle atleten die zwemmen en druk deze dan af
	public static void searchSportType(ArrayList<Atleet> arrayList, Sport searchSportType) {

		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getSport().equals(searchSportType)) {

				System.out.println("Voornaam	: " + String.valueOf(arrayList.get(i).getVoornaam()));
				System.out.println("Achternaam	: " + String.valueOf(arrayList.get(i).getAchternaam()));
				System.out.println("Sport		: " + String.valueOf(arrayList.get(i).getSport()));
				System.out.println("GeboorteDatum	: " + String.valueOf(arrayList.get(i).getGeboorteDatum()));
				System.out.println();
			}
		}
	}

	// zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
	public static void searchFirstNameAndSportType(ArrayList<Atleet> arrayList, String firstName,
			Sport searchSportType) {

		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getVoornaam().equals(firstName)
					&& arrayList.get(i).getSport().equals(searchSportType)) {

				System.out.println("Voornaam	: " + String.valueOf(arrayList.get(i).getVoornaam()));
				System.out.println("Achternaam	: " + String.valueOf(arrayList.get(i).getAchternaam()));
				System.out.println("Sport		: " + String.valueOf(arrayList.get(i).getSport()));
				System.out.println("GeboorteDatum	: " + String.valueOf(arrayList.get(i).getGeboorteDatum()));
				System.out.println();

			}
		}
	}
}
