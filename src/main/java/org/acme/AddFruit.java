package org.acme;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.acme.dto.Fruit;
import picocli.CommandLine;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@CommandLine.Command(name = "write", description = "write about fruit")
class AddFruit implements Runnable {

    @CommandLine.Option(names = {"-n", "--name"}, description = "name of fruit", defaultValue = "None")
    private String name;
    @CommandLine.Option(names = {"-d", "--desc"}, description = "description of fruit", defaultValue = "No description provided")
    private String description;

    /*
    takes input Fruit(name and description) from user and
    adds to data.json file as JsonArray.
    eg = --------   write -n mango -d "king of fruits"
     */
    @Override
    public void run() {
        try {
            Fruit fruit = new Fruit(name, description);
            List<Fruit> fruitList = new ArrayList<>();
            fruitList.add(fruit);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("assets/json/data.json").toFile(), fruitList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
