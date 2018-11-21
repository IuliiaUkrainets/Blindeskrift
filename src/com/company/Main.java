package com.company;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, Integer> wordToBraile = new HashMap<>();
    static Map<String,String> punctuationsToBraile = new HashMap<>();
    static {
        wordToBraile.put("but", 10243);
        wordToBraile.put("can", 10249);
        wordToBraile.put("do", 10265);
        wordToBraile.put("every", 10257);
        wordToBraile.put("from", 10251);
        wordToBraile.put("go", 10267);
        wordToBraile.put("have", 10259);
        wordToBraile.put("just", 10266);
        wordToBraile.put("knowledge", 10280);
        wordToBraile.put("like", 10296);
        wordToBraile.put("more", 10253);
        wordToBraile.put("not", 10269);
        wordToBraile.put("people", 10255);
        wordToBraile.put("quite", 10271);
        wordToBraile.put("rather", 10263);
        wordToBraile.put("so", 10254);
        wordToBraile.put("that", 10270);
        wordToBraile.put("us", 10277);
        wordToBraile.put("very", 10279);
        wordToBraile.put("it", 10285);
        wordToBraile.put("you", 10301);
        wordToBraile.put("as", 10293);
        wordToBraile.put("and", 10287);
        wordToBraile.put("for", 10303);
        wordToBraile.put("of", 102295);
        wordToBraile.put("the", 10286);
        wordToBraile.put("with", 10302);
        wordToBraile.put("will", 10298);
        wordToBraile.put("his", 10278);
        wordToBraile.put("in", 10260);
        wordToBraile.put("was", 10292);
        wordToBraile.put("to", 10262);

        punctuationsToBraile.put(",","⠂");
        punctuationsToBraile.put(";","⠆");
        punctuationsToBraile.put(":","");
        punctuationsToBraile.put(".","⠲");
        punctuationsToBraile.put("!","");
        punctuationsToBraile.put("(","");
        punctuationsToBraile.put(")","");
        punctuationsToBraile.put("?","⠢");
        punctuationsToBraile.put("/","");
        punctuationsToBraile.put("#","");
        punctuationsToBraile.put("’","");
        punctuationsToBraile.put("-","⠤");
        punctuationsToBraile.put("_","");
        punctuationsToBraile.put("\\","");
        punctuationsToBraile.put("a","⠁");
        punctuationsToBraile.put("b","⠃");
        punctuationsToBraile.put("c","⠉");
        punctuationsToBraile.put("d","⠙");
        punctuationsToBraile.put("e","⠑");
        punctuationsToBraile.put("f","⠋");
        punctuationsToBraile.put("g","⠛");
        punctuationsToBraile.put("h","⠓");
        punctuationsToBraile.put("i","⠊");
        punctuationsToBraile.put("j","⠚");
        punctuationsToBraile.put("k","⠅");
        punctuationsToBraile.put("l","⠇");
        punctuationsToBraile.put("m","⠍");
        punctuationsToBraile.put("n","⠝");
        punctuationsToBraile.put("o","⠕");
        punctuationsToBraile.put("p","⠏");
        punctuationsToBraile.put("q","⠟");
        punctuationsToBraile.put("r","⠗");
        punctuationsToBraile.put("s","⠎");
        punctuationsToBraile.put("t","⠞");
        punctuationsToBraile.put("u","⠥");
        punctuationsToBraile.put("v","⠧");
        punctuationsToBraile.put("w","⠺");
        punctuationsToBraile.put("x","⠭");
        punctuationsToBraile.put("y","⠽");
        punctuationsToBraile.put("z","⠵");

    }

    public static void main(String[] args) {
        System.out.println(new Character((char) 10286));

        String[] text = new Main().readInputFile("input.txt").split(" ");
        new Main().writeOutputFile("test", String.join(" ",filter(text)));
    }

    public String readInputFile(String path) {
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(encoded, Charset.defaultCharset());
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
            for (String key : wordToBraile.keySet()) {
                if (text[i].equals(key)) {
                    text[i] = String.valueOf(wordToBraile.get(key));
                }
            }
            for (String item : punctuationsToBraile.keySet()) {
                if (text[i].contains(item)) {
                    text[i]= text[i].replace(item, punctuationsToBraile.get(item));
                }
            }
        }
        return text;
    }
}
