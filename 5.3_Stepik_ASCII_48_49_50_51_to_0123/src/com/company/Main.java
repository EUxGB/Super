package com.company;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {

        int tt;
        byte [] bb = {48,49,50,51};
        InputStream stream = new ByteArrayInputStream(bb);
        System.out.println(MyFile.readAsString(stream, StandardCharsets.US_ASCII));

    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        int tmp;
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader stream = new InputStreamReader(inputStream, charset);

        while ((tmp = stream.read()) != -1) {
            stringBuilder = stringBuilder.append((char) tmp);
        }

        return stringBuilder.toString();
    }

}
