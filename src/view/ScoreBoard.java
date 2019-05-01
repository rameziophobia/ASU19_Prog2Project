package view;

import java.io.*;
import java.util.ArrayList;

public class ScoreBoard {
    private final String path = Main.PATH_RESOURCES_SAVES + "highscores.dat";
    private ArrayList<String> data;
    //score data format --> SCORE:NAME

    private File scoreFile = new File(path);
    public ScoreBoard() {
        loadScoreData();
    }

    public void loadScoreData() {
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != "") {
                data.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File not found");
            //todo handling exceptions
        }
    }

    public void addToData(String name, String score) {
        String entry = score + ":" + name;
        data.add(entry);
        writeToFile(data);
    }

    private void writeToFile(ArrayList<String> scores) {
        FileWriter writeFile;
        BufferedWriter writer = null;
        try {
            writeFile = new FileWriter(scoreFile);
            writer = new BufferedWriter(writeFile);
        } catch (Exception e) {
            //todo handling exceptions
        }
        if (!scoreFile.exists()) {
            try {
                scoreFile.createNewFile();
            } catch (IOException e) {
                //todo handling exceptions
            }
        }
        int i = 0;
        while (i < scores.size()) {
            String entry = scores.get(i);
            try {
                writer.newLine();
                writer.write(entry);

            } catch (Exception e) {
                //todo handling exceptions
            }
            i++;
        }
        if (writer != null)
            try {
                writer.close();
            } catch (Exception e) {
                //todo handling exceptions
            }
    }

    public ArrayList<ScoreData> getData() {//todo return data as string and int
        ArrayList<ScoreData> scoreList = new ArrayList<>();
        int j = 0;
        while (j < data.size()){
            scoreList.add(new ScoreData(data.get(j)));
            j++;
        }
        return scoreList;
    }
}
class ScoreData{
    private String name;
    private int score;

    public ScoreData(String entry){
        String[] Arr = entry.split(":");
        score = Integer.parseInt(Arr[0]);
        name = Arr[1];
    }


}