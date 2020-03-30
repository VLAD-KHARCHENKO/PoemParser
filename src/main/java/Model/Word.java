package Model;

public class Word implements Comparable<Word> {

    private String word;
    private Integer count;
    private String url;

    public Word(String word, Integer count, String url) {
        this.word = word;
        this.count = count;
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "                                                      " +
                "\nWord: " +
                word +
                "\nCount: " +
                count +
                "\nSonnet URL: " +
                url +
                "\n                                                   ";
    }

    @Override
    public int compareTo(Word word) {
        return this.count < word.count ? 1 : -1;
    }

}

