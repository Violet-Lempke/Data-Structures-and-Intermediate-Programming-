package lab08;

//import java.util.Arrays;
/**
 *Code that gets run when debugging.  
 *
 *@author Nat Tuck
 */
public class App {
    /**
    *Iterates and Prints a BinTree.
    *
    *@author Nat Tuck
    *
    *@param args Our arguements
    */
    public static void main(String[] args) {
        //var xs = TreeSet.set(TreeSet.set("a", "b"), TreeSet.set("a"));
        //xs.contains(TreeSet.set("a", "b")));
        //xs.contains(TreeSet.set("a", "c")));
        //System.out.println("" + xs);

        var bt = BinTree.<Integer>makeEmpty();
        bt = bt.insert(7);
        bt = bt.insert(2);
        bt = bt.insert(1);
        bt = bt.insert(3);
        bt = bt.insert(10);
        bt = bt.insert(7);
        bt = bt.insert(11);

        for (var xx : bt) {
            System.out.println("" + xx);
        }
    }
}

 
