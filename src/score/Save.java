package score;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Save {

    private String benchpoints;

    public Save(long benchpoints) {
        this.benchpoints = String.valueOf(benchpoints);
    }

    public void saveScore() throws Exception {

        List<String> names = Score.getNames();
        String dirName = "Saves";

        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("(dd-MM-yyyy)-(HH-mm-ss)");
        LocalDateTime dateTime = LocalDateTime.now();

        String dateTimeStamp = dTF.format(dateTime);

        String fileName = "DMCPU-" + dateTimeStamp + "-" + benchpoints + ".txt";

        File file = new File(dirName + File.separator + fileName);
        File directory = new File(dirName);

        if (!directory.exists()) {
            if (!directory.mkdir()) throw new Exception("Failed to create saves directory!");
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));

        for (int x = 0; x < names.size(); x++) {
            bufferedWriter.write(((names.get(x) + ": " + Math.round(Score.getFromScores(names.get(x)))) + (x == names.size() - 2 ? System.lineSeparator() + System.lineSeparator() : System.lineSeparator())));
        }

        bufferedWriter.flush();
        bufferedWriter.close();

    }

}
