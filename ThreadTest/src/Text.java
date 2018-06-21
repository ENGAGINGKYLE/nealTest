import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Text {
    public static ArrayList inputText(String sourceFileName) {
        ArrayList lines = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(sourceFileName));
            String strLine = null;
            while ((strLine = br.readLine()) != null) {
                strLine = strLine.trim();
                lines.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lines;
    }

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat fmat = new SimpleDateFormat("HH:mm:ss");
        String string = "2008-8-8 20:08:08";
        Long timestamp = null;

        try {
            timestamp = sdf.parse(string).getTime();
        } catch (Exception e) {
            e.printStackTrace();

        }

        Date date = new Date(timestamp);
        String s = fmat.format(date);
        System.out.println(timestamp + "\n" + s);
    }
}
