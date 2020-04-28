import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Sort {
    private long count;
    private long exchange;

    public abstract int sort(int[] input);

    public void  write(String fileName, String str) {
        File file = new File(fileName);
        FileWriter fw;
        BufferedWriter bw;

        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(str);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void increaseCount() {
        count++;
    }

    public long getCount() {
        count = count + exchange;
        exchange = 0;
        return count;
    }

    public void increaseExchange() {
        exchange++;
    }
}
