package org.liveangel.A;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

@Component
public class FileRead {


    public void read() {

        File file = new File("daf/2018050223-00030.gz");
        InputStream in =  null;
        try {
            in = new GZIPInputStream(new FileInputStream(file));
            Scanner sc=new Scanner(in);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭输入流
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}