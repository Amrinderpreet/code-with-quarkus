package org.acme;

import picocli.CommandLine;
import javax.inject.Inject;


@CommandLine.Command(name = "write", description = "write about fruit")
class AddFruit implements Runnable {
    @Inject
    FruitResource fruitResource;

    @CommandLine.Option(names = {"-n", "--name"}, description = "name of fruit", defaultValue = "None")
    String name;
    @CommandLine.Option(names = {"-d", "--desc"}, description = "description of fruit", defaultValue = "No description provided")
    String description;

    /*
    takes input Fruit(name and description) from user and
    adds to data.json file as JsonArray.
    eg = --------   write -n mango -d "king of fruits"
     */

    @Override
    public void run() {
        Fruit fruit = new Fruit(name, description);
        fruitResource.write(fruit);
    }
}
