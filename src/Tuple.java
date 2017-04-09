import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by maria on 2017-04-06.
 */

public class Tuple {
    int document;
    double tf;

    public Tuple(int document, double tf) {
        this.document = document;
        this.tf = tf;
    }


    // Sort by tf in descending order
    public static ArrayList<Tuple> sortTuples(ArrayList<Tuple> list) {
        Collections.sort(list, Comparator.comparing(t -> -t.tf));

        return list;
    }

}