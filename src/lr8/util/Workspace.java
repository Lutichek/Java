package lr8.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public final class Workspace {

    private static final Path BASE =
            Paths.get(System.getProperty("zaripov.workdir", "./.workdir/zaripov"));

    private Workspace() {
    }

    public static Path file(String fileName) {
        try {
            Files.createDirectories(BASE);
        } catch (IOException ex) {
            throw new UncheckedIOException("Не удалось создать рабочий каталог " + BASE, ex);
        }
        return BASE.resolve(fileName);
    }
}
