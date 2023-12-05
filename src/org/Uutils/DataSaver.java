package org.Uutils;

import java.io.*;

public class DataSaver implements Serializable {
    private final Object data;

    public DataSaver(Object data) {
        this.data = data;
    }
    public DataSaver saveData(String filepath) throws Exception {
        if (data != null && isSERFile(filepath)){
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath));
            out.writeObject(this);
            out.close();
        }else
            throw new NullPointerException("-> Is no data to save 😔<-");
        return this;
    }
    private boolean isSERFile(String filepath) throws Exception {
        boolean[] txt = {false,false,false};
        if (filepath.length() <= 4)
            throw new Exception("-> The file has to be a .ser file 😔<-");
        txt[0] = filepath.charAt(filepath.length() - 1) == 'r';
        txt[1] = filepath.charAt(filepath.length() - 2) == 'e';
        txt[2] = filepath.charAt(filepath.length() - 3) == 's';
        if(txt[0] && txt[1] && txt[2])
            return true;
        else
            throw new Exception("-> The file has to be a .ser file 😔<-");
    }
    public static Object getData(String filepath) throws IOException, ClassNotFoundException {
        if(!new File(filepath).exists())
            throw new FileNotFoundException("-> The file is not exist 😔<-");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filepath));
        DataSaver dataSaver = (DataSaver) in.readObject();
        return dataSaver.data;
    }
}
