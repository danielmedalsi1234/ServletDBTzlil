package com.company;
import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.omg.CORBA.PRIVATE_MEMBER;


import java.io.*;

public class Main {

    public static final String pathToDesktop = "/home/danielmedalsi1234/Desktop/";

    public static void main(String[] args) {


        //createFileWithTryAndCatch();
        //createFileWitheIfAndElse();
        //createAndWriteTofile();
        //createAndWriteTofileWithOutputstream("outputstream 2");
        //WriteToExistfileWithOutputstream("it workkkk mother fucker!!!!");
        readFromFile();

    }

    //this method without ask if the file is exist
    public static void createFileWithTryAndCatch() {
        File newFlie = new File(pathToDesktop);
        try {
            try {
                FileWriter fileWriter = new FileWriter(newFlie);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                System.out.println("the file is created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {

        }
    }

    //this method ask if the file is exist!!!
    public static void createFileWitheIfAndElse() {
        File newFile = new File(pathToDesktop);
        if (!newFile.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(newFile);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                System.out.println("the newFile2 is created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            System.out.println("the file is exist");
    }

    public static void createAndWriteTofile() {
        File newFile = new File(pathToDesktop);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        PrintWriter printWriter;

        if (!newFile.exists()) {
            try {

                fileWriter = new FileWriter(newFile);
                bufferedWriter = new BufferedWriter(fileWriter);
                printWriter = new PrintWriter(bufferedWriter);
                printWriter.println("line1");
                printWriter.println("line2");
                printWriter.println("line3");
                printWriter.close();
                System.out.println("the file is created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("the file is already exist");

        }

    }

    public static void createAndWriteTofileWithOutputstream(String s) {
        File file = new File(pathToDesktop + "myTextOutputstream");
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

    //this method wite to a exist file!
    public static void WriteToExistfileWithOutputstream(String newString) {
        File file = new File(pathToDesktop + "myTextOutputstream.txt");
        if (!file.exists()) {
            System.out.println("the file doesnt exist");
        }else {
            try {
                OutputStream outputStream = new FileOutputStream(file);
                try {
                    outputStream.write(newString.getBytes());
                    System.out.println("the strig is update");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFromFile(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(pathToDesktop + "myTextOutputstream.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                line = br.readLine();
                System.out.println(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String everything = sb.toString();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}