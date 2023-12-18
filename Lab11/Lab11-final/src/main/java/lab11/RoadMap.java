package lab11;

import java.util.List;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;
/**
 *Creates a graph of cities. 
 *
 *@author Violet Lempke, Nat Tuck
 */
public class RoadMap {
    TreeMap<String, City> cities;
    /**
     *Initializes an empty roadMap.
     */
    RoadMap() {
        cities = new TreeMap<String, City>();
    }
    /**
     *Adds a city to the RoadMap.
     *
     * @param name name of the city
     *
     * @param yy y coordinate of the city
     *
     * @param xx x coordinate of the city
     *
     * @param neighbors cities directly connected to the city
     */
    void addCity(String name, double yy, double xx, List<String> neighbors) {
        var ns = new TreeSet<String>();
        ns.addAll(neighbors);
        var city = new City(xx, yy, ns);
        this.cities.put(name, city);
    }
    /**
     *Gets a city from the RoadMap given it's name.
     *
     * @param name string, the name of the city
     *
     * @return a City
     */
    City getCity(String name) {
        return this.cities.get(name);
    }
    /**
     *Returns the neighbors of a city in a navigable set.
     *
     * @param name name of the city
     *
     * @return a navigable set of the city's neighbors
     */
    NavigableSet<String> getNeighbors(String name) {
        return this.getCity(name).ns();
    }
    /**
     *Returns a navigable set of the cities in a graph.
     *
     * @return A navigable set of all the cities in the graph. 
     */
    NavigableSet<String> listCities() {
        return this.cities.navigableKeySet();
    }
    /**
     *Returns the distance between two cities. 
     *
     * @param name0 the name of the first city
     *
     * @param name1 the name of the second city
     *
     * @return a double representing the distance
     */
    double dist(String name0, String name1) {
        return Math.sqrt(Math.pow(getCity(name0).y() - getCity(name1).y(), 2) 
            + Math.pow(getCity(name0).x() - getCity(name1).x(), 2));
        
    }
    /**
     *Creates a roadMap of New Hampshire.
     *
     * @return the RoadMap
     */
    static RoadMap getNewHampshire() {
        var mm = new RoadMap();
        mm.addCity("Keene", 1.0, 1.0, List.of("Peterborough", "Claremont", "Hillsboro"));
        mm.addCity("Peterborough", 1.0, 2.0, List.of("Keene", "Nashua", "Hillsboro"));
        mm.addCity("Nashua", 1.0, 3.0, List.of("Peterborough", "Manchester"));
        mm.addCity("Salem", 1.0, 4.0, List.of("Londonderry"));
        mm.addCity("Londonderry", 2.0, 4.0, List.of("Manchester", "Salem"));
        mm.addCity("Manchester", 2.0, 3.0, List.of("Nashua", "Concord", "Londonderry"));
        mm.addCity("Hillsboro", 3.0, 2.0, List.of("Keene", "Peterborough", "Concord"));
        mm.addCity("Portsmouth", 3.0, 5.0, List.of("Concord", "Conway"));
        mm.addCity("Claremont", 4.0, 1.0, List.of("Keene", "Lebanon"));
        mm.addCity("Concord", 4.0, 3.0,
                   List.of("Hillsboro", "Manchester", "Portsmouth", "Tilton", "Lebanon"));
        mm.addCity("Tilton", 5.0, 3.0, List.of("Concord", "Laconia", "Plymouth"));
        mm.addCity("Lebanon", 6.0, 1.0, List.of("Claremont", "Concord"));
        mm.addCity("Laconia", 6.0, 4.0, List.of("Tilton"));
        mm.addCity("Plymouth", 7.0, 3.0, List.of("Tilton", "Lincoln"));
        mm.addCity("Lincoln", 8.0, 3.0, List.of("Plymouth", "Conway", "Gorham"));
        mm.addCity("Conway", 8.0, 5.0, List.of("Portsmouth", "Lincoln", "Gorham"));
        mm.addCity("Gorham", 9.0, 5.0, List.of("Lincoln", "Conway"));
        return mm;
    }
}
/**
 *Essentially the constructor for a city. 
 *
 *@author Nat Tuck
 *
 *@param x the x coordinate of the city
 *
 *@param y the y coordinate of the city
 *
 *@param ns the neighbors of the city
 */
record City(double x, double y, TreeSet<String> ns) {
    // no extra methods
}
