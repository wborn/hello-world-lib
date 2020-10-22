package com.acme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PinguinSay {

    private static final Logger LOGGER = LoggerFactory.getLogger(PinguinSay.class);

    public static void print(String text) {
        createTextLines(text).forEach(System.out::println);
    }

    public static void log(String text) {
        createTextLines(text).forEach(LOGGER::info);
    }

    private static List<String> createTextLines(String text) {
        List<String> lines = new ArrayList<>();

        int width = 40;

        String[] splitted = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : splitted) {
            int newLength = sb.length() + word.length() + 1;
            if (width < newLength) {
                int padding = width - sb.length();
                if (padding > 0) {
                    sb.append(String.join("", Collections.nCopies(padding, " ")));
                }
                sb.insert(0, "| ");
                sb.append("|");
                lines.add(sb.toString());
                sb.setLength(0);
            }
            sb.append(word);
            sb.append(" ");
        }

        if (sb.length() > 0) {
            int padding = width - sb.length();
            if (padding > 0) {
                sb.append(String.join("", Collections.nCopies(padding, " ")));
            }
            sb.insert(0, "| ");
            sb.append("|");

            lines.add(sb.toString());
        }

        if (lines.size() == 1) {
            lines.set(0, "<" + lines.get(0).substring(1, width + 2) + ">");
        } else {
            lines.set(0, "/" + lines.get(0).substring(1, width + 2) + "\\");
            lines.set(lines.size() - 1, "\\" + lines.get(lines.size() - 1).substring(1, width + 2) + "/");
        }

        lines.add(0, " _________________________________________");
        lines.add(" -----------------------------------------");
        lines.add("   \\");
        lines.add("    \\");
        lines.add("        .--.");
        lines.add("       |o_o |");
        lines.add("       |:_/ |");
        lines.add("      //   \\ \\");
        lines.add("     (|     | )");
        lines.add("    /'\\_   _/`\\");
        lines.add("    \\___)=(___/");

        return lines;
    }
}
