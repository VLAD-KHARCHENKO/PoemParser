package Controller;

import Model.Word;
import View.ViewParser;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ControllerParser {

    ViewParser view;

    public ControllerParser(ViewParser view ){
        this.view = view;

    }

    public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);

        in.close();

        return response.toString();
    }

    public static Map<String, Map<String, Integer>> pushMap() throws Exception {
        Map<String, Map<String, Integer>> sonnet = new HashMap<>();
        for (int i = 1; i < 155; i++) {
            Map<String, Integer> words = new HashMap();

            String url = "https://stihi-rus.ru/World/Shekspir/" + i + ".htm";


            String str = getText(url);

            String[] breakWords = str.split(" ");


            for (String word : breakWords) {

                Integer freq = words.get(word);
                words.put(word, (freq == null) ? 1 : freq + 1);

            }
            sonnet.put(url, words);

        }
        return sonnet;
    }

    public void findWord(Map<String, Map<String, Integer>> map,String string) throws IOException {
      //  ViewParser view = new ViewParser();
     //   String string = view.read();
        Set<Word> entryWords = new TreeSet<>();
        boolean contains = false;

        for (Map.Entry<String, Map<String, Integer>> entryOut : map.entrySet()) {
            if (entryOut.getValue().containsKey(string)) {
                Integer count = (entryOut.getValue()).get(string);
                entryWords.add(new Word(string, count, entryOut.getKey()));

                contains = true;
            }
        }
        if (!contains && !string.equals("0")) {
            view.massage("NOT FOUND");

        }
        for (Word word : entryWords)
            System.out.println(word);
    }
    public void start() throws Exception {
view.massage("Please wait, program is parsing");
        findWord(pushMap(),view.read());

    }
}