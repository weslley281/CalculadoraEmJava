package br.com.cod3r.calc.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    private enum CommandType {
        RESET, NUMBER, DIV, MULT, SUM, EQUAL, COMMA, SUB
    }
    private static final Memory instance = new Memory();
    private final List<ObserverMemomy> observers = new ArrayList<>();
    private String actualText = "";
    private Memory(){

    }
    public static Memory getInstance(){
        return instance;
    }

    public void addObserver(ObserverMemomy observer){
        observers.add(observer);
    }
    public String getActualText() {
        return actualText.isEmpty() ? "0" : actualText;
    }

    public void setActualText(String actualText) {
        this.actualText = actualText;
    }

    public void processCommand(String text){
        CommandType commandType = detectCommandType(text);
        if ("AC".equals(text)){
            actualText = "";
        }else {
            actualText += text;
        }
        observers.forEach(o -> o.valueChanged(actualText));
    }

    private CommandType detectCommandType(String text) {
        if (actualText.isEmpty() && text == "0"){
            return null;
        }

        try {
            Integer.parseInt(text);
            return CommandType.NUMBER;
        }catch (NumberFormatException e){
            if ("AC".equals(text)){
                return CommandType.RESET;
            } else if ("/".equals(text)) {
                return CommandType.DIV;
            }else if ("*".equals(text)) {
                return CommandType.MULT;
            }else if ("+".equals(text)) {
                return CommandType.SUM;
            }else if ("-".equals(text)) {
                return CommandType.SUB;
            }else if ("=".equals(text)) {
                return CommandType.EQUAL;
            }else if (",".equals(text)) {
                return CommandType.COMMA;
            }
        }
        return null;
    }
}
