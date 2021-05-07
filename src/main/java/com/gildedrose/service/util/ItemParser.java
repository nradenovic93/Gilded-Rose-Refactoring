package com.gildedrose.service.util;

import com.gildedrose.service.domain.Item;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ItemParser {

    public static Item[] parseFromFile(String resourceName) {
        ClassPathResource resource = new ClassPathResource(resourceName);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream()))) {
            return reader.lines()
                    .map(ItemParser::parseFromLine)
                    .collect(Collectors.toList())
                    .toArray(new Item[]{});
        } catch (IOException e) {
            throw new RuntimeException("Failed to read items from classpath resource " + resourceName, e);
        }
    }

    private static Item parseFromLine(String line) {
        String[] splitLine = line.split(";");
        String name = parseAsString(splitLine, 0);
        int sellIn = parseAsInt(splitLine, 1);
        int quality = parseAsInt(splitLine, 2);
        return new Item(name, sellIn, quality);
    }

    private static int parseAsInt(String[] list, int index) {
        String value = fetchIndex(list, index);
        return Integer.parseInt(value);
    }

    private static String parseAsString(String[] list, int index) {
        return fetchIndex(list, index);
    }

    private static String fetchIndex(String[] list, int index) {
        try {
            return list[index];
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("List has length " + list.length + ", requested index " + index + " out of bounds", e);
        }
    }
}