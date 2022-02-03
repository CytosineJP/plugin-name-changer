package work.tmail.cytosine.pnc;

import java.io.File;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws Exception {
        File input = new File("input.jar");
        try (FileSystem fs = FileSystems.newFileSystem(URI.create("jar:" + input.toURI()), null)) {
            Path path = fs.getPath("plugin.yml");
            String contents = new String(Files.readAllBytes(fs.getPath("plugin.yml")), StandardCharsets.UTF_8);
            contents = contents.replaceAll("plugin:.*", "plugin: " + args[0]);
            Files.write(path, contents.getBytes(StandardCharsets.UTF_8));
        }
    }
}
