import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) throws IOException {
        File file = Paths.get(" ").toFile();
        getCountUniqIps(file);
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(System.getProperty("local separator"));
        while (scanner.hasNext()){
            System.out.println("***"+ scanner.next());
        }
        scanner.close();
    }

    public static void getCountUniqIps(File file) throws IOException {
        int countUniqIps = 0;
        try (FileChannel fileChannel = FileChannel.open(file.toPath(), EnumSet.of(StandardOpenOption.READ))
        ) {
            MappedByteBuffer mbBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            if (mbBuffer != null) {
                String bufferContent =
                        StandardCharsets.UTF_8.decode(mbBuffer).toString();
                countUniqIps = Math.toIntExact(Arrays.stream(bufferContent.split("\\s+"))
                        .distinct().count());
                mbBuffer.clear();
            }

        }
    }
}
