package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import model.Continent;
import model.Country;
import model.GameMap;
import model.Player;
import utils.MapValidation;
import utils.ValidationException;

import java.util.Iterator;
import java.util.ListIterator;

public class mapView {

public static void showMap(GameMap gameMap) {
        
		System.out.println("\nShowing the Map Details\n");
		
		// Showing the players in game
		
				HashMap<String, Player> players=gameMap.getPlayers();
				System.out.println("Players: ");
				if(players!=null) {
					
					players.forEach((key, value) -> System.out.println(key + " : " + value));  // will slightly modify the output after testing with the entire project
				System.out.println();
				}
				
				
				
        // Showing Continents in Map
		Iterator<Entry<String, Continent>> iteratorForContinents = gameMap.getContinents().entrySet()
				.iterator();

		String table = "|%-18s|%n";

		System.out.format("+------------------+%n");
		System.out.format("| Continent's name |%n");
		System.out.format("+------------------+%n");

		while (iteratorForContinents.hasNext()) {
			Map.Entry<String, Continent> continentMap = (Map.Entry<String, Continent>) iteratorForContinents.next();
			String continentId = (String) continentMap.getKey();
			Continent continent = gameMap.getContinents().get(continentId); //Get the particular continent by its ID(Name)

			System.out.format(table, continent.getName());
		}

		System.out.format("+------------------+%n");


		// Showing Countries in the Continent and their details
		
		Iterator<Entry<String, Continent>> iteratorForContinent = gameMap.getContinents().entrySet()
				.iterator();

	//	table = "|%-14s|%-23s|%-18s|%-28s|%-15s|%-15s|%n";
		table = "|%-23s|%-18s|%-60s|%-15s|%n";

		System.out.format(
				"+--------------+-----------------------+------------------+----------------------------+---------------+---------------+%n");
		System.out.format(
				"     Country's name     | Continent's Name |   Neighbour countries' ID                                  | No. of armies |%n");
		System.out.format(
				"+--------------+-----------------------+------------------+----------------------------+---------------+---------------+%n");

		while (iteratorForContinent.hasNext()) {
			Map.Entry<String, Continent> continentMap = (Map.Entry<String, Continent>) iteratorForContinent.next();
			String continentId = (String) continentMap.getKey();
			Continent continent = gameMap.getContinents().get(continentId); // to get the continent by its ID(Name)
			//ListIterator<Country> listIterator = continent.getCountries().listIterator();
			Iterator<Country> listIterator = continent.getCountries().iterator();
			while (listIterator.hasNext()) {

			Country country = (Country) listIterator.next();

		//System.out.format(table, country.getId(), country.getName(), continent.getName(),country.getNeighbors(),country.getArmies(), country.getPlayer().getName());
		System.out.format(table, country.getName(), continent.getName(),country.getNeighbors(),country.getArmies());

			}
		}

		System.out.format(
				"+--------------+-----------------------+------------------+----------------------------+---------------+---------------+%n");
	
	
	
		
		//Showing the Ownership of the players
		String table1 = "|%-15s|%-30s|%-21d|%n";

		System.out.format(
				"+---------------+-----------------------+------------------------------+---------------------+%n");
		System.out.format(
				"| Player's name |    Continent's Controlled    | No. of Armies Owned |%n");
		System.out.format(
				"+---------------+-----------------------+------------------------------+---------------------+%n");

		

			
		
	//	players.forEach((key, value) -> 
	//	//System.out.format(table1, players.getName(), players.getCapturedCountries(),players.getNumberOfArmies()); //Have to add a function GetNumberOfArmies in Player
	
		

	//	System.out.format("+---------------+-----------------------+------------------------------+---------------------+%n");

	}
	
public static void main(String args[]) throws ValidationException {
    MapValidation map = new MapValidation();
    GameMap gameMap = new GameMap();
    gameMap.addContinent("Asia", "5");
    gameMap.addContinent("US", "5");
    gameMap.addContinent("Africa", "5");
    gameMap.addContinent("Anta", "5");
    gameMap.addContinent("Aus", "5");

    gameMap.addCountry("Pak", "Africa");
    gameMap.addCountry("India", "Asia");
    gameMap.addCountry("Newyork", "US");
    gameMap.addCountry("Penguin", "Anta");
    gameMap.addCountry("Melbourne", "Aus");

    gameMap.addNeighbor("Pak", "India");
    gameMap.addNeighbor("India", "Pak");
    gameMap.addNeighbor("Pak", "Newyork");
    gameMap.addNeighbor("Newyork", "Pak");
    gameMap.addNeighbor("Penguin", "India");
    gameMap.addNeighbor("India", "Penguin");
    gameMap.addNeighbor("Penguin", "Melbourne");
    gameMap.addNeighbor("Melbourne", "Penguin");
    
    


   // System.out.println(map.validateMap(gameMap, 2));
    showMap(gameMap);
}

}
