package br.com.cod3r.calc.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    private enum CommandType {
        RESET, NUMBER, DIV, MULT, SUM, EQUAL, COMMA, SUB
    }
    private static final Memory instance = new Memory();
    private final List<ObserverMemomy> observers = new ArrayList<>();
    private CommandType lastOperation = null;
    private String actualText = "";
    private String bufferText = "";
    private boolean replace = false;
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

        if (commandType == null){
            return;
        } else if (commandType == CommandType.RESET) {
            actualText = "";
            bufferText = "";
            replace = false;
            lastOperation = null;
        } else if (commandType == CommandType.NUMBER || commandType == CommandType.COMMA) {
            actualText = replace ? text : actualText + text;
            replace = false;
        }else {
            replace = true;
            actualText = getOperationResult();
            bufferText = actualText;
            lastOperation = commandType;
        }

        observers.forEach(o -> o.valueChanged(actualText));
    }

    private String getOperationResult() {
        if (lastOperation == null){
            return actualText;
        }
        double bufferNumber = Double.parseDouble(bufferText.replace(",","."));
        double actualNumber = Double.parseDouble(actualText.replace(",","."));
        double result = 0;
        if (lastOperation == CommandType.SUM) {
            result = bufferNumber + actualNumber;
        } else if (lastOperation == CommandType.MULT) {
            result = bufferNumber * actualNumber;
        }else if (lastOperation == CommandType.DIV) {
            result = bufferNumber / actualNumber;
        }else if (lastOperation == CommandType.SUB) {
            result = bufferNumber - actualNumber;
        }

        String resultString = Double.toString(result).replace(".",",");
        boolean integer = resultString.endsWith(",0");
        return integer ? resultString.replace(",0", "") : resultString;
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
            }else if (",".equals(text) && !actualText.contains(",")) {
                return CommandType.COMMA;
            }
        }
        return null;
    }
}
