package com.ryanmichela;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("echo ERROR: Path to script file is missing");
            return;
        }

        List<String> commands = parseInput(args[0]);

        int cmdIdx = 0;
        boolean supress = false;

        Reader isr = new InputStreamReader(System.in, Charset.defaultCharset());
        int c;

        do {
            c = isr.read();
            if ((char)c == '`' && !supress) {
                System.out.print("\b");
                type(commands.get(cmdIdx));

                cmdIdx++;
                supress = true;
            }
            if ((char)c == '\n' && supress) {
                supress = false;
            }
        } while(c != -1 && cmdIdx != commands.size());
    }

    private static void type(String command) {
        Random r = new Random();
        for(char c : command.toCharArray()) {
            System.out.print(c);

            try {
                if (c == ' ') {
                    // pause a little longer for spaces
                    Thread.sleep(200 + 10 * r.nextInt(5));
                } else {
                    Thread.sleep(80 + 3 * r.nextInt(10));
                }
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

    private static List<String> parseInput(String path) {
        List<String> lines = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("echo ERROR: Input file does not exist");
        } else if (!file.isFile()) {
            System.out.println("echo ERROR: Input is not a file");
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException ex) {
                System.out.println("echo ERROR: "+ ex.getMessage());
            }
        }
        return lines;
    }
}
