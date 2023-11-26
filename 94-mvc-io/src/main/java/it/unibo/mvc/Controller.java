package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setNextStringPrint(String text);

    String getNextStringPrint();

    List<String> getPrintHistory();

    void printString();

}
