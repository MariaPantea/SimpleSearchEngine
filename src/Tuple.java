import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by maria on 2017-04-06.
 *
 * This implementation only calculates the tf-score instead of tf-idf, since the idf term is the same for all words
 * and hence doesn't contribute to the sorting.
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