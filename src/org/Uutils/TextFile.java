package org.Uutils;

import java.io.*;
public class TextFile extends File{
    private final String filepath;

    public TextFile(String filepath) throws Exception {
        super(filepath);
        this.filepath = filepath;
        if (!this.exists() && DataSaver.isCorrectFile("txt",filepath)){
            try {
                this.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
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
