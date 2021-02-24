public static void assignCountries(GameMap gameMap) {
		 int player_index=0;		
		List<Player> players = gameMap.getPlayers().values().stream().collect(Collectors.toList());
	
		List<Country> countryList = gameMap.getCountries().values().stream().collect(Collectors.toList());  //get all countries from each continent
								
			Collections.shuffle(countryList);
			for(int i = 0; i < countryList.size(); i++) {
				
				Country c = countryList.get(i);                // loop for get each country of the map
				Player p =players.get(player_index);          // find the corresponding player by the order of the player				
				p.getCapturedCountries().add(c); 
				c.setPlayer(p);
				System.out.println(c.getName()+" Assigned to "+p.getName());
				if(player_index<gameMap.getPlayers().size()-1) {     //if not all players get a new country in this round
					player_index++;
				}
				else {                                         //if all players get a new counter in this round, start from player 1
					player_index=0;
				}	
			}	
		}	
