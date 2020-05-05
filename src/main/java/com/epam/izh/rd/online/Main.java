package com.epam.izh.rd.online;

import com.epam.izh.rd.online.helper.FileReaderService;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        FileReaderService fileReaderService = new FileReaderService();
        System.out.println(fileReaderService.readFromFileToString("sample-text.txt"));



    }
}
