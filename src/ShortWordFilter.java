import java.util.ArrayList;

public class ShortWordFilter implements Filter{
    @Override
    public boolean accept(Object x) {
        String word;
        word = x.toString();
        return word.length() < 5;
    }

    public ArrayList<Object> collectAll(ArrayList<String> words) {
        ArrayList<Object> accepted = new ArrayList<>();
        ArrayList<Object> objectArray = new ArrayList<>();

        objectArray.addAll(words);

        for (Object i : objectArray) {
            if (accept(i)) {
                accepted.add(i);
            }
        }

        return accepted;
    }
}
