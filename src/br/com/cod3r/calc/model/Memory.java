package br.com.cod3r.calc.model;

public class Memory {
    private static final Memory instance = new Memory();
    private String actualText = "";
    private Memory(){

    }
    public static Memory getInstance(){
        return instance;
    }

    public String getActualText() {
        return actualText.isEmpty() ? "0" : actualText;
    }

    public void setActualText(String actualText) {
        this.actualText = actualText;
    }
}
