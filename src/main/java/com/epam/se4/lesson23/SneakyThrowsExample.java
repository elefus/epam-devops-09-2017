package com.epam.se4.lesson23;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SneakyThrowsExample {

    public static void main(String[] args) throws IOException {
        closedStreamProblemExample();
//        charArrayWriterExample();
//        pipesExample();
    }

    private static void closedStreamProblemExample() throws IOException {
        try (FileReader reader = new FileReader("test.txt")) {
            BufferedReader reader1 = new BufferedReader(reader);

            for (String curr = reader1.readLine(); curr != null; curr = reader1.readLine()) {
                System.out.println(curr);
            }
            reader1 = null;

            System.out.println("After:");

            while (reader.ready()) {
                int symbol = reader.read();
                System.out.print((char) symbol);
            }
        }
    }

    private static void charArrayWriterExample() {
        CharArrayWriter charArrayWriter = new CharArrayWriter(100);
        charArrayWriter.write('1');
        charArrayWriter.write('1');
        charArrayWriter.write('2');
        charArrayWriter.write('3');
        char[] chars = charArrayWriter.toCharArray();
        charArrayWriter.write('a');
        charArrayWriter.write('b');
        charArrayWriter.write('c');
        char[] chars1 = charArrayWriter.toCharArray();
    }

    @SneakyThrows
    public static void pipesExample() {
        PipedInputStream pipeIn = new PipedInputStream(5);
        PipedOutputStream pipeOut = new PipedOutputStream(pipeIn);

        for (int i = 0; i < 20; i++) {
            pipeOut.write(i);
        }
        pipeOut.write(-1);

        int willRead = pipeIn.available();
        byte[] toRead = new byte[willRead];

        for (int i = 0; i < willRead; i++) {
            toRead[i] = (byte) pipeIn.read();
        }
        System.out.print(Arrays.toString(toRead));
    }

    public List<Integer> square(List<Integer> nums) {
        return nums.stream().map(value -> value * value).collect(Collectors.toList());
    }


    @SneakyThrows
    public static void readFromFile(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            System.out.println((char)reader.read());
        }
    }
}
