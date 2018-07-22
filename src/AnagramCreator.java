import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

class AnagramCreator {

    HashMap<String, String> map = new HashMap<String, String>();

    void hash() throws IOException {
        File file = new File("/home/sangeetagupta1998/Desktop/words.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));


        String line, temporaryValue;

        map.put("", "");

        String key;
        int count = 0;

        while ((line = reader.readLine()) != null) {

            line = line.trim();

            char temp[] = line.toLowerCase().toCharArray();
            Arrays.sort(temp);
            String line2 = new String(temp);

            if (map.containsKey(line2)) {

                temporaryValue = map.get(line2) + line + ",";
                map.put(line2, temporaryValue);


            } else {

                temporaryValue = line;
                map.put(line2, temporaryValue);

            }


        }


        reader.close();

    }

    public void filterAnagram() {

        ArrayList<String> haveNoAnagrams = new ArrayList<>();
        String key = "";

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {

            key = iterator.next().toString();

            if (map.get(key).equals("")) {
                haveNoAnagrams.add(key);
            }

        }

        map.keySet().removeAll(haveNoAnagrams);
    }

    public void displayAnagram() {

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {

            System.out.println("key: " + iterator.next());
            System.out.println("values : " + map.get(iterator.next()));
            System.out.println("/////");
        }
    }


    public static void main(String... args) {
        AnagramCreator anagramCreator = new AnagramCreator();
        try {
            anagramCreator.hash();
            anagramCreator.filterAnagram();
            anagramCreator.displayAnagram();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}

