package lab14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import kotlin.Pair;
import static kotlin.collections.MapsKt.mapOf;

public class App {
    final static String URL = "https://words.homework.quest/socket/websocket";
    //final static String URL = "http://localhost:4000/socket/websocket";

    static Chan chan = null;

    public static void main(String[] args) {
        int zz = (int)(1000 * Math.random());
        chan = new Chan(URL, "162", "VioletTest5500");
        chan.guess("t");
    }

    public static void onJoin(Map<String, Object> msg) {
        System.out.println("keys: " + msg.keySet());
    }

    public static void onView(Map<String, Object> msg) {
        System.out.println("keys: " + msg.keySet());
        System.out.println("puzzle: " + (String) msg.get("puzzle"));
        @SuppressWarnings("unchecked")
        var gs = new HashSet<String>((List<String>) msg.get("guesses"));
        System.out.println("guesses: " + gs);
        System.out.println(msg.get("active"));
        if (msg.get("active").equals("162")) {

            if (((String)(msg.get("puzzle"))).contains("-")) {
                var letters = "abcdefghijklmnopqrstuvwxyz".split("");
                var ng = "t";
                
                while (((msg.get("guesses").toString())).contains(ng)) {
                    ng = letters[(int)(26 * Math.random())];
                }
                chan.guess(ng);
            }
            else {
                System.out.println("Game done");
                System.exit(0);
            }
        }
        if (!((String) msg.get("puzzle")).contains("-")) {
            System.out.println("Game Done");
            System.out.println(msg.get("game"));
            System.exit(0);
        }
    }
}
