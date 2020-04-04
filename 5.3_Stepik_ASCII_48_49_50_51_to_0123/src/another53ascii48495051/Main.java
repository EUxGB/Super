package another53ascii48495051;

import com.company.MyFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        int tt;
        byte [] bb = {48,49,50,51,52};
        InputStream stream = new ByteArrayInputStream(bb);
        System.out.println(readAsString(stream, StandardCharsets.US_ASCII));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        byte[] s = new byte[1024];
        inputStream.read(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);

        }

        return new String(s,charset).trim();
    }
}
