package org.Uutils;

import java.io.*;

public class DataSaver implements Serializable {
    private final Object data;

    public DataSaver(Object data) {
        this.data = data;
    }
    private DataSaver saveData(String filepath) throws Exception {
        if (data != null && isCorrectFile("ser",filepath)){
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath));
            out.writeObject(this);
            out.close();
        }else
            throw new NullPointerException("-> Is no data to save 😔<-");
        return this;
    }
    public static void saveData(Object data, String filepath){
        try {
            new DataSaver(data).saveData(filepath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean isCorrectFile(String type, String filepath) throws Exception {
        boolean[] ser = {false,false,false};
        char[] cType = type.toCharArray();
        if (filepath.length() <= 4)
            throw new Exception("-> The file has to be a ." + type +" file 😔<-");
        ser[0] = filepath.charAt(filepath.length() - 1) == cType[2];
        ser[1] = filepath.charAt(filepath.length() - 2) == cType[1];
        ser[2] = filepath.charAt(filepath.length() - 3) == cType[0];
        if(ser[0] && ser[1] && ser[2])
            return true;
        else
            throw new Exception("-> The file has to be a ." + type + " file 😔<-");
    }
    public static Object getData(String filepath) throws IOException, ClassNotFoundException {
        if(!new File(filepath).exists())
            throw new FileNotFoundException("-> The file is not exist 😔<-");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filepath));
        DataSaver dataSaver = (DataSaver) in.readObject();
        return dataSaver.data;
    }
}
