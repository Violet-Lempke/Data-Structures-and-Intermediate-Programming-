package lab11;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.TreeMap;

/**
 *Finds the shortest Path between two nodes.
 *
 *@author Violet Lempke
 */
public class FindPath {
    /**
     *initializes the needed data to find the shortest path.
     *
     * @param mm a graph
     *
     * @param src starting node
     *
     * @param dst ending node 
     *
     * @return a list of strings
     */
    static List<String> findPath(RoadMap mm,
                                 String src,
                                 String dst) {
        var infos = new TreeMap<String, CityInfo>();
        var queue = new MinHeap<CityInfo>((aa, bb) -> compare(aa, bb));

        var srcInfo = new CityInfo(src, null, 0.0);
        infos.put(src, srcInfo);

        return findPath(mm, infos, queue, src, src, dst);
    }
    /**
     *Returns the shortest path between two nodes. 
     *
     * @param mm a graph
     *
     * @param infos city info 
     *
     * @param queue a queue for containing city info
     *
     * @param src starting node
     *
     * @param cur starting node
     *
     * @param dst ending node
     *
     * @return a list of strings
     */
    static List<String> findPath(RoadMap mm,
                                 TreeMap<String, CityInfo> infos,
                                 MinHeap<CityInfo> queue,
                                 String src,
                                 String cur,
                                 String dst) {
        // Probably not this.
        
        var unvisitedSetup = new ArrayList<String>();
        var cities = mm.listCities();
        var finalValues = new TreeMap<String, CityInfo>();
        for (var city : cities) {
            unvisitedSetup.add(city);
        }
        var unvisited = new TreeMap<String, CityInfo>();
        unvisited.put(src, infos.get(src));
        for (var city : unvisitedSetup) {
            var curCityInfo = new CityInfo(city, null, Double.POSITIVE_INFINITY);
            unvisited.put(city, curCityInfo);
        }
        unvisited.replace(src, infos.get(src));
        while (unvisited.containsKey(dst)) {
            var neighbors = mm.getCity(cur).ns();
            for (var neighbor : neighbors) {
                if (unvisited.containsKey(neighbor)) {
                    var newTent = new CityInfo(neighbor, cur, (mm.dist(cur, neighbor))
                        + unvisited.get(cur).srcDist);
                    if (unvisited.get(neighbor).srcDist > newTent.srcDist) {
                        unvisited.replace(neighbor, newTent);
                    }

                }
            }
            
            finalValues.put(cur, unvisited.get(cur));
            unvisited.remove(cur);
           
            double SmallestValue = Double.POSITIVE_INFINITY;
            
            var keySet = unvisited.keySet();
            for (var city : keySet) {
                if (unvisited.get(city).srcDist < SmallestValue) {
                    SmallestValue = unvisited.get(city).srcDist;
                    cur = city;
                }
            }
            
        }

        var finalPath = new ArrayList<String>();
        var xx = dst;
        while (xx != null) {
            queue.add(finalValues.get(xx));
            xx = finalValues.get(xx).prev;
            
        }
        while (queue.peek().name != dst) {
            finalPath.add(queue.poll().name);
        }
        finalPath.add(dst);
        if (!finalPath.contains(src)) {
            throw new RuntimeException("Nodes not connected");
        }
        return finalPath;

        
    }
    /**
     *builds a path given a tree of city info.
     *
     * @param infos TreeMap of city info
     *
     * @param dst starting node
     *
     * @param src ending node 
     *
     * @return a list of strings
     */
    static List<String> buildPath(TreeMap<String, CityInfo> infos,
                                  String dst,
                                  String src) {
        var ys = new ArrayList<String>();

        while (!dst.equals(src)) {
            ys.add(dst);
            var di = infos.get(dst);
            dst = di.prev;
        }

        ys.add(src);
        
        Collections.reverse(ys);
        return ys;
    }
    /**
     *Compares the srcDist of two Cities.
     *
     * @param aa first cities info
     *
     * @param bb second cities info 
     *
     * @return an int
     */
    static public int compare(CityInfo aa, CityInfo bb) {
        var ad = Double.valueOf(aa.srcDist);
        var bd = Double.valueOf(bb.srcDist);
        return ad.compareTo(bd);
    }
}
/**
 *Basic setup for a city.
 *
 *@author Nat Tuck
 */
class CityInfo {
    String name;
    String prev;
    double srcDist;
    boolean done;
    /**
     *Constructor for cityInfo.
     *
     * @param name City's name
     *
     * @param prev Connected node with the shortest distance to src
     *
     * @param srcDist Distance from source
     */
    CityInfo(String name, String prev, double srcDist) {
        this.name = name;
        this.prev = prev;
        this.srcDist = srcDist;
        this.done = false;
    }
}
