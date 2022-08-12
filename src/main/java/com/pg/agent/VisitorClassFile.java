package com.pg.agent;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class VisitorClassFile {

    public static void main(String[] args) throws IOException {

        String re = "./Test.class";
        byte[] bytes = FileUtils.readFileToByteArray(new File(re));

        String hex_str = HexUtils.format(bytes, HexFormat.FORMAT_FF_SPACE_FF_32);
        System.out.println(hex_str);


    }
}
