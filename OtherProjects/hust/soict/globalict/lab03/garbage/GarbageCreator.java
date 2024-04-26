package OtherProjects.hust.soict.globalict.lab03.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "OtherProjects\\hust\\soict\\globalict\\lab03\\garbage\\text.exe";
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
