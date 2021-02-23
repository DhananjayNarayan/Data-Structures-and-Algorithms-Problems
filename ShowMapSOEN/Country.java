package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.*;

/**
 * Concrete Class to set and get all the properties of country.
 *
 * @author Neona Pinto
 * @author Dhananjay Narayan
 * @author Surya Manian
 * @author Madhuvanthi Hemanathan
 * @author Prathika Suvarna
 */
public class Country {
    private String d_Id;
    private String d_Name;
    private String d_Continent;
    private Player d_Player;
    private int d_Armies;
    private Set<Country> d_Neighbors;
    private Set<String> d_NeighborsName;
	
   

    /**
     * Get the country ID
     *
     * @return d_Id Country ID of type int
     */
    public String getId() {
        return d_Id;
    }

    /**
     * Set the country ID
     *
     * @param p_Id Country ID
     */
    public void setId(String p_Id) {
        this.d_Id = p_Id;
    }

    /**
     * Get the country name
     *
     * @return d_Name The country name
     */
    public String getName() {
        return d_Name;
    }

    /**
     * Set the country name
     *
     * @param p_Name Country name
     */
    public void setName(String p_Name) {
        this.d_Name = p_Name;
    }

    /**
     * Get the continent name, the country belongs to
     *
     * @return d_Continent Continent name
     */
    public String getContinent() {
        return d_Continent;
    }

    /**
     * Set the continent name, the country belongs to
     *
     * @param p_Continent Continent name
     */
    public void setContinent(String p_Continent) {
        this.d_Continent = p_Continent;
    }

    /**
     * Get the player instance for the game play
     *
     * @return d_Player Player instance
     */
    public Player getPlayer() {
    	d_player.put()
        return d_Player;
    }

    /**
     * Set the player instance for the game play
     *
     * @param p_Player Player instance
     */
    public void setPlayer(Player p_Player) {
        this.d_Player = p_Player;
    }

    /**
     * Get the number of armies for the country
     *
     * @return d_Armies Number of armies for the country
     */
    public int getArmies() {
        return d_Armies;
    }

    /**
     * Set the armies for the country
     *
     * @param p_Armies Number of armies for the country
     */
    public void setArmies(int p_Armies) {
        this.d_Armies = p_Armies;
    }

    public Set<Country> getNeighbors() {
        if (d_Neighbors == null) {
            d_Neighbors = new HashSet<>();          
        }
        return d_Neighbors;
    }
     

	public void setNeighbors(Country p_Neighbor) {
        if (d_Neighbors == null) {
            d_Neighbors = new HashSet<>();
        }
        d_Neighbors.add(p_Neighbor);
    }
	//Dhananjay Code
	public void setNeighborsName(String p_NeighborCountryName) {
        if (d_NeighborsName == null) {
            d_NeighborsName = new HashSet<>();
        }
        d_NeighborsName.add(p_NeighborCountryName);
    }
	//Dhananjay Code
	 public Set<String> getNeighborsName() {        
	        if (d_NeighborsName == null) {
	            d_NeighborsName = new HashSet<>();          
	        }
	        return d_NeighborsName;
	    }
}
