package com.example.rtt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadClass {
    public List<String> ReadFileFromStorge(String string){
        List<String> maclist=new ArrayList<>();
        File file=new File(string);
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String macstring;
            while((macstring=bufferedReader.readLine())!=null){
                macstring=macstring.trim();
                maclist.add(macstring);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maclist;
    }

}
