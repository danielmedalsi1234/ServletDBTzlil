package com.company;

import java.io.*;

public class Main {
    public static final String pathToDesktop = "/home/danielmedalsi1234/Desktop/";

    public static void main(String[] args) {
        createAndWriteTofileWithOutputstream("hi my name is daniel");
        // write your code here
    }

    public static void createAndWriteTofileWithOutputstream(String s) {
        File file = new File(pathToDesktop + "textFromClient");
        if (!file.exists()) {
            try {
                OutputStream outputStream = new FileOutputStream(file);
                try {
                    outputStream.write(s.getBytes());
                    outputStream.close();
                    System.out.println("ok");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Bad");
        }
    }


}
