import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static StringBuilder logFile = new StringBuilder();

    public static void main(String[] args) {
        List<String> listPathDir = new ArrayList<>();
        List<String> listPathFile = new ArrayList<>();

        listPathDir.add("c://Games/src");
        listPathDir.add("c://Games/res");
        listPathDir.add("c://Games/savegames");
        listPathDir.add("c://Games/temp");
        listPathDir.add("c://Games/src/main");
        listPathDir.add("c://Games/src/test");
        listPathFile.add("c://Games/src/main/Main.java");
        listPathFile.add("c://Games/src/main/Utils.java");
        listPathDir.add("c://Games/res/drawables");
        listPathDir.add("c://Games/res/vectors");
        listPathDir.add("c://Games/res/icons");
        listPathFile.add("c://Games/temp/temp.txt");
        for (String s : listPathDir) {
            makeDir(s);
        }
        for (String s : listPathFile) {
            makeFile(s);
        }

        writeFile("c://Games/temp/temp.txt");

    }

    private static void makeDir(String path) {
        File makedDir = new File(path);
        logFile.append(makedDir.mkdir()
                ? "Папка " + makedDir.toString() + " успешно создана. \n"
                : "Папка " + makedDir.toString() + " не создана. \n");
    }

    private static void makeFile(String path) {
        File makedFile = new File(path);
        try {
            logFile.append(makedFile.createNewFile()
                    ? "Файл " + makedFile.toString() + " успешно создан. \n"
                    : "Файл " + makedFile.toString() + " не создан. \n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(String path) {
        try (FileWriter writerTempTxt = new FileWriter(path, false)) {
            writerTempTxt.write(logFile.toString());
            writerTempTxt.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}