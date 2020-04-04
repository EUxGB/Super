package com.company;

import java.io.*;
import java.nio.charset.Charset;

public class MyFile {

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        int tmp;
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader stream = new InputStreamReader(inputStream, charset);

        while ((tmp = stream.read()) != -1) {
            stringBuilder.append((char) tmp);
        }

        return stringBuilder.toString();
    }

}
