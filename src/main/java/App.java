package ua.jec;
import Controller.ControllerParser;
import View.ViewParser;


public class App {


    public static void main(String[] args) throws Exception {
        ViewParser view = new ViewParser();
        ControllerParser controller = new ControllerParser(view);
        controller.start();


    }
}