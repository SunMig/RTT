package com.example.rtt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileReadClass {
    private Point point;
    //读取MAC地址，
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

    //读取MAC与对应的坐标,设想是先读取内存的坐标，在线阶段根据搜到的AP数量，动态调整LS算法的A、L矩阵
    public HashMap<String,Point> ReadCoordFileFromStorge(String string){
        HashMap<String,Point> hashMap=new HashMap<>();
        File file=new File(string);
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String macstring;
            String[] str=new String[3];
            while((macstring=bufferedReader.readLine())!=null){
                macstring=macstring.trim();
                str=macstring.split("\t");
                point=new Point(Double.parseDouble(str[1]),Double.parseDouble(str[2]));
                point.setX(Double.parseDouble(str[1]));
                point.setY(Double.parseDouble(str[2]));
                hashMap.put(str[0],point);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
