import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by maria on 2017-04-04.
 */

public class SearchEngine {

    static Map<String, ArrayList> vocabulary = new HashMap<>();


    public static void updateVocabulary (String[] documents) {
        int docNum = 1;

        // For each document; clean and get length
        for (String document : documents) {
            Map<String, Double> tf = new HashMap<>();
            document = cleanDocument(document);
            String[] words = document.split(" ");
            int docLength = words.length;


            // For each word; count the number of occurences of each word
            for (String word : words) {
                double count = tf.containsKey(word) ? tf.get(word) : 0;
                tf.put(word, count + 1);

            }
            // Calculate the tf-score and add the tuple to vocabulary
            for (Map.Entry<String, Double> c : tf.entrySet()) {

                 double tfScore = c.getValue() / docLength;
                 Tuple tuple = new Tuple(docNum, tfScore);
                 String word = c.getKey();
                 ArrayList<Tuple> values = vocabulary.get(word);

                 // word not in vocabulary -> Add word
                 if (values == null){
                    ArrayList<Tuple> newValues = new ArrayList<>();
                    newValues.add(tuple);
                    vocabulary.put(word, newValues);
                 }
                 // Add tuple to list of values
                 else {
                    values.add(tuple);
                    //Tuple.sortTuples(values);
                    vocabulary.put(word, values);
                }


            }

            docNum++;
        }                                            
    }


    // Clean the document from punctuation (contractions are no dealt with atm).
    private static String cleanDocument(String doc) {
        String document = doc.replaceAll("[,.!?\"()]", " ").toLowerCase();
        return document;
    }

    public static ArrayList<Integer> search(String word){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Tuple> sortedTuples = Tuple.sortTuples(vocabulary.get(word));

        for (Tuple tuple : sortedTuples){
            list.add(tuple.document);
        }

        return list;
    }



    public static void main(String[] args) {

        String[] documents = {
                "the brown fox jumped over the brown dog",
                "the lazy brown dog sat in the corner",
                "the red fox bit the lazy dog cat",
                "fox"
        };

        updateVocabulary(documents);

        String searchWord = "brown";
        System.out.print(searchWord + ": " + search(searchWord));


    }

}
