package org.acme;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class FruitResource {
    @Inject
    ObjectMapper mapper;

    private List<Fruit> fruitList = new ArrayList<>();

    public void read(String fileName) {

        try {
            fruitList = Arrays.asList(mapper.readValue(Paths.get("assets/json/" + fileName).toFile(), Fruit[].class));
            fruitList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write(Fruit fruit) {

        try {
            fruitList.add(fruit);
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("assets/json/data.json").toFile(), fruitList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

