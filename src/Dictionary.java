
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

    public class Dictionary {
        private List<String> listWords;
        private final String filename;

        public Dictionary(String filename) {
            this.filename = filename;
            loadListWordsFromFile();
        }

        private void loadListWordsFromFile() {
            InputStream resource = this.getClass().getClassLoader().getResourceAsStream(filename);
            if (resource == null) {
                throw new RuntimeException("File " + filename + " not found");
            }
            this.listWords = new BufferedReader(new InputStreamReader(resource)).lines().toList();
        }

        protected String getRandomWordFromList() {
            return listWords.get(new Random().nextInt(listWords.size())).toLowerCase();
        }
    }

