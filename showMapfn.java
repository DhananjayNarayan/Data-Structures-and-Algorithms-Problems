public void showMap(GameMap gameMap) {
        
		
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

		String table = "|%-16d|%-18s|%n";

		System.out.format("+----------------+------------------+%n");
		System.out.format("| Continent's ID | Continent's name |%n");
		System.out.format("+----------------+------------------+%n");

		while (iteratorForContinents.hasNext()) {
			Map.Entry<String, Continent> continentMap = (Map.Entry<String, Continent>) iteratorForContinents.next();
			String continentId = (String) continentMap.getKey();
			Continent continent = gameMap.getContinents().get(continentId); //Get the particular continent by its ID(Name)

			System.out.format(table, continent.getId(), continent.getName());
		}

		System.out.format("+----------------+------------------+%n");


		// Showing Countries in the Continent and their details
		
		Iterator<Entry<String, Continent>> iteratorForContinent = gameMap.getContinents().entrySet()
				.iterator();

		table = "|%-14d|%-23s|%-18s|%-28s|%-15s|%-15s|%n";

		System.out.format(
				"+--------------+-----------------------+------------------+----------------------------+---------------+---------------+%n");
		System.out.format(
				"| Country's ID |     Country's name    | Continent's Name |   Adjacent countries' ID   | No. of armies | Player's name |%n");
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

		System.out.format(table, country.getId(), country.getName(), continent.getName(),country.getNeighbors(),country.getArmies(), country.getPlayer().getName());
		//System.out.format(table, country.getId(), country.getName(), continent.getName(),country.getNeighbors().get,country.getArmies(), country.getPlayer().getName());

			}
		}

		System.out.format(
				"+--------------+-----------------------+------------------+----------------------------+---------------+---------------+%n");
	
	
	
		
		//Showing the Ownership of the players
		String table1 = "|%-15s|%-23f|%-30s|%-21d|%n";

		System.out.format(
				"+---------------+-----------------------+------------------------------+---------------------+%n");
		System.out.format(
				"| Player's name |    Continent's Controlled    | No. of Armies Owned |%n");
		System.out.format(
				"+---------------+-----------------------+------------------------------+---------------------+%n");

		

			
		
		players.forEach((key, value) -> 
		System.out.format(table1, players.getName(), players.getCapturedCountries(),players.getNumberOfArmies()); //Have to add a function GetNumberOfArmies in Player
	
		

		System.out.format("+---------------+-----------------------+------------------------------+---------------------+%n");

	}
