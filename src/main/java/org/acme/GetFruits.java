package org.acme;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.acme.dto.Fruit;
import picocli.CommandLine;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@CommandLine.Command(name = "read", description = "gets fruits")
class GetFruits implements Runnable {

    @CommandLine.Option(names = {"-f", "--file"}, description = "name of file", defaultValue = "fruits.json")
    String fileName;

    /*Reads .json file and consoles it
    * by default fruits.json is read,
    * other files can be read by adding "-f 'filename' ".
    * eg == read -f data.json */
    @Override
    public void run() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Fruit> fruits = Arrays.asList(mapper.readValue(Paths.get("assets/json/" + fileName).toFile(), Fruit[].class));
            fruits.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

