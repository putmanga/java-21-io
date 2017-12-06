package com.company;

import java.io.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/ilya/Desktop/FileToRead.txt");
//        InputStream inputStream = new FileInputStream(file);
        InputStream inputStream = new URL("https://google.com").openStream();
        OutputStream outputStream = System.out;
        copy(inputStream, outputStream);
    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buff = new byte[64 * 1024];

        while (inputStream.available() > 0) {
            int count = inputStream.read(buff);

            outputStream.write(buff, 0, count);
        }
        inputStream.close();
        outputStream.close();
    }
}
