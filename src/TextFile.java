import java.io.*;

public class TextFile {
    private final String filepath;

    public TextFile(String filepath) {
        File file = new File(filepath);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
    public void addText(String text){
        String fileText = getText();
        write(fileText + text);
    }
    public void addTextNewLine(String text){
        String fileText = getText();
        write(fileText + "\n" + text);
    }
}
