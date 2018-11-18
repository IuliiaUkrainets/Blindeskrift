package com.company;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<String, Integer> map = new HashMap<>();
    static List<String> punctuations = new ArrayList<>();
    static {
        map.put("but", 10243);
        map.put("can", 10249);
        map.put("do", 10265);
        map.put("every", 10257);
        map.put("from", 10251);
        map.put("go", 10267);
        map.put("have", 10259);
        map.put("just", 10266);
        map.put("knowledge", 10280);
        map.put("like", 10296);
        map.put("more", 10253);
        map.put("not", 10269);
        map.put("people", 10255);
        map.put("quite", 10271);
        map.put("rather", 10263);
        map.put("so", 10254);
        map.put("that", 10270);
        map.put("us", 10277);
        map.put("very", 10279);
        map.put("it", 10285);
        map.put("you", 10301);
        map.put("as", 10293);
        map.put("and", 10287);
        map.put("for", 10303);
        map.put("of", 102295);
        map.put("the", 10286);
        map.put("with", 10302);
        map.put("will", 10298);
        map.put("his", 10278);
        map.put("in", 10260);
        map.put("was", 10292);
        map.put("to", 10262);

        punctuations.add(",");
        punctuations.add(";");
        punctuations.add(":");
        punctuations.add(".");
        punctuations.add("!");
        punctuations.add("(");
        punctuations.add(")");
        punctuations.add("?");
        punctuations.add("/");
        punctuations.add("#");
        punctuations.add("’");
        punctuations.add("-");
        punctuations.add("-");
        punctuations.add("_");
        punctuations.add("\\");

    }

    public static void main(String[] args) {
        System.out.println(new Character((char) 10286));
        new Main().writeOutputFile("test", String.valueOf((char) 10286));
    }

    public String[] readInputFile(String path) {
        return null;
    }

    public void writeOutputFile(String path, String data) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String[] filter(String[] text) {
        for (int i = 0; i< text.length; i++) {
            for (char letter : text[i].toCharArray()){
                if (Character.isDigit(letter)) {
                    text[i] = text[i].replace(""+letter, "⠼"+(char)(96+((byte)letter-48)));
                }
            }
            for (String key : map.keySet()) {
                if (text[i].equals(key)) {
                    text[i] = String.valueOf(map.get(key));
                }
            }
            for (String item : punctuations) {
                if (text[i].contains(item)) {
                    text[i]= text[i].replace(item, "");
                }
            }
        }
        return text;
    }
}
