package nl.sey.adventure;

public class AdventereTest {
	
	/* we weten dat het spel begint bij de rivier
	 * -> test of de start-positie de rivier is
	 */
	public static String testStartLocatie(Adventure adventure) {
		String startNaam = adventure.getLocatieNaam(); 
		if(startNaam == "rivier") {
			return "succes: start is bij de rivier";
		} else {
			return "MISLUKT: start is bij de " + startNaam;
		}
	}
	
	/* we weten dat je vanuit de startpositie naar o en naar n kan
	 * -> test dat het aantal richting van de startpositie 2 is
	 */
	public static String testStartRichtingen(Adventure adventure) {
		Locatie locatie = Locatie.zoekOpNaam("rivier");
		int richtingen = locatie.getAantalVerbindingen();
		if(richtingen == 2) {
			return "succes: aantal richtingen van startpositie is 2";
		} else {
			return "MISLUKT: aantal richtingen is " + richtingen;
		}
	}
	
	/* we weten dat dat we vanaf de berg naar z en o kunnen
	 * -> test dat we vanaf de berg naar zuid kunnen
	 */
	public static String testBergNaarZuid(Adventure adventure) {
		Locatie locatie = Locatie.zoekOpNaam("berg");
		Locatie nieuw = locatie.gaNaar('z');
		if(nieuw == null) {
			return "MISLUKT: niet gelukt om van top naar z te gaan";
		} else {
			return "succes: gelukt om van top naar z te gaan";			
		}
	}

	/* we weten dat dat we vanaf de top naar w kunnen
	 * -> test dat we vanaf de berg niet naar noord kunnen
	 */
	public static String testTopNietNaarNoord(Adventure adventure) {
		Locatie locatie = Locatie.zoekOpNaam("top");
		Locatie nieuw = locatie.gaNaar('n');
		if(nieuw == null) {
			return "succes: je kunt niet naar noord";
		} else { 
			return "MISLUKT: je kunt naar noord";
		}
		
		
	}

	public static void main(String[] args) {
		Adventure adventure = new Adventure();
		System.out.println("Test start locatie:       " + testStartLocatie(adventure));
		System.out.println("Test start richtingen:    " + testStartRichtingen(adventure));
		System.out.println("Test berg naar zuid:      " + testBergNaarZuid(adventure));
		System.out.println("Test top niet naar noord: " + testTopNietNaarNoord(adventure));

	}
}
