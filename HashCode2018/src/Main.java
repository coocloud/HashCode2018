import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream out = new FileOutputStream("file/hello.out");
        try {
            fis = new FileInputStream("file/hello.in");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
        BufferedWriter writer = null;
        writer = new BufferedWriter(new OutputStreamWriter(out));


        String line = bufferedReader.readLine();
        String firstLine[] = line.split(" ");
    }
}
