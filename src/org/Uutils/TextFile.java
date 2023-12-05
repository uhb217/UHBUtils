package org.Uutils;

import java.io.*;

public class TextFile extends File{
    private final String filepath;

    public TextFile(String filepath) {
        super(filepath);
        this.filepath = filepath;
        if (!this.exists() && isTXTFile()){
            try {
                this.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean isTXTFile(){
        boolean[] txt = {false,false,false};
        if (filepath.length() <= 4) {
            try {
                throw new Exception("The file is not a txt file");
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        txt[0] = filepath.charAt(filepath.length() - 1) == 't';
        txt[1] = filepath.charAt(filepath.length() - 2) == 'x';
        txt[2] = filepath.charAt(filepath.length() - 3) == 't';
        if(txt[0] && txt[1] && txt[2])
            return true;
        else {
            try {
                throw new Exception("The file is not a txt file");
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
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
