package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT_FILE = System.getProperty("user.home")
            + File.separator + "output.txt";

    private File file;

    public Controller() {
        this.file = new File(DEFAULT_FILE);
    }

    public void setFile(final File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public String getFilePath() {
        return this.file.getAbsolutePath();
    }

    public void writeOnFile(final String text) throws IOException {
        try (PrintStream p = new PrintStream(this.file, StandardCharsets.UTF_8)) {
            p.print(text);
        }
    }

}
