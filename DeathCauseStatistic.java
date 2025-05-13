import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DeathCauseStatistic {
    private String icdCode;
    private int[] numOfDeathsInGroup;//20


    public static ArrayList<DeathCauseStatistic> readCsvFile(String fileName) {
        try {
            ArrayList<DeathCauseStatistic> deathCauseStatistics = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("stuff/zgony.csv"));
            String line = br.readLine();
            String[] tokens = line.split(",");
            for (int i = 2; i < tokens.length; i++) {
                String[] brackets = tokens[i].replace(" ", "").split("-");
                int left = Integer.parseInt(brackets[0]);
                AgeBracketDeaths.getInstance(i).young = left;
            }
            line = br.readLine();
            tokens = line.split(",");
            for (int i = 2; i < tokens.length; i++) {
                AgeBracketDeaths.getInstance(i).deathCount = Integer.parseInt(tokens[i]);
            }
            while ((line = br.readLine()) != null) {
                deathCauseStatistics.add(fromCsvLine(line));
            }
            return deathCauseStatistics;
        }catch (FileNotFoundException ex){
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static DeathCauseStatistic fromCsvLine(String line){
        String lineWithoutWhiteCharacters = line.replace(" ","");
        String[] lineParts = lineWithoutWhiteCharacters.split(",");
        String icdCode = lineParts[0];



        int[] numOfDeathsInGroup = new int[lineParts.length - 2];
        for(int i = 2; i < lineParts.length; i++){
            if(lineParts[i].equals("-")){
                numOfDeathsInGroup[i-2] = 0;
            }else {
                numOfDeathsInGroup[i-2] = Integer.parseInt(lineParts[i]);
            }
        }
        return new DeathCauseStatistic(icdCode, numOfDeathsInGroup);
    }

    public DeathCauseStatistic(String icdCode, int[] numOfDeathsInGroup) {
        this.icdCode = icdCode;
        this.numOfDeathsInGroup = numOfDeathsInGroup;
    }

    public String getIcdCode() {
        return icdCode;
    }
    public AgeBracketDeaths getAgeBracketDeaths(int age) {
        age /= 5;
        age *= 5;
        return AgeBracketDeaths.getInstance(age);
    }
    public static class AgeBracketDeaths{
        int young, deathCount;

        private static AgeBracketDeaths[] instances;

        public static AgeBracketDeaths getInstance(int age) {
            int i = age/5;
            int numOfDeathsInGroup;
            if(instances == null){
                instances = new AgeBracketDeaths[20];
            }
            if (instances[i] == null) {
                instances[i] = new AgeBracketDeaths(age);
            }
            return instances[i];
        }

        public AgeBracketDeaths(int young) {

        }
    }
}
