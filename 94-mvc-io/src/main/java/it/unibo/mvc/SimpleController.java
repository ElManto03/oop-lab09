package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> stringHistory;
    private String toPrint;

    public SimpleController() {
        this.stringHistory = new ArrayList<>();
    }

    @Override
    public void setNextStringToPrint(final String toPrint) {
        Objects.requireNonNull(toPrint);
        this.toPrint = toPrint;
    }

    @Override
    public String getNextStringToPrint() {
        return this.toPrint;
    }

    @Override
    public List<String> getPrintHistory() {
        return List.copyOf(this.stringHistory);
    }

    @Override
    public void printString() {
        if (Objects.isNull(toPrint)) {
            throw new IllegalStateException("String to print is unset");
        }
        System.out.println(toPrint);
        this.stringHistory.add(toPrint);
    }

}
