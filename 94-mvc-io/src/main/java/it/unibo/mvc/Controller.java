package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setNextStringToPrint(String text);

    String getNextStringToPrint();

    List<String> getPrintHistory();

    void printString();

}
