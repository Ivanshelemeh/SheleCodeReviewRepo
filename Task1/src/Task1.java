import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

public class Task1 {

    public static void main(String[] args) throws IOException {
        String filename = "";
        Path path= Paths.get(filename);
        File newFile =  path.toFile();
        long countFile = getCountUniqIps(newFile);
        System.out.println(countFile);

        }

    public static long getCountUniqIps(final File f) throws IOException {
        long countIps = 0L;
        //used TreeSet for sorting values
        Set<String> stringSet =  new TreeSet<>();

        try(BufferedReader br = Files.newBufferedReader(f.toPath())){
            String buffLine;
            while ((buffLine = br.readLine())!= null){
                stringSet.add(buffLine);
            }
            countIps =stringSet.size();
        }
         return countIps;

    }
}
