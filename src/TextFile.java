import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TextFile {
    private final String filepath;

    public TextFile(String filepath) {
        this.filepath = filepath;
    }
    public String getFilepath(){
        return filepath;
    }
    public String getText(){
        String text = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if (text.equals("")){
                    text += line;
                }else
                    text += "\n" + line;
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
    public void write(String text){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath));
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
