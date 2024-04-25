package OtherProjects.hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "test.exe";
        byte[] inputBytes = {0};
        long startTime, endTIme;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b: inputBytes) {
            outputString += (char)b;
        }
        endTIme = System.currentTimeMillis();
        System.out.println(endTIme - startTime);
    }
}
