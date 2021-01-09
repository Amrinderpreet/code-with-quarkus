package org.acme;

import picocli.CommandLine;
import javax.inject.Inject;

@CommandLine.Command(name = "read", description = "gets fruits")

class GetFruits implements Runnable {
    @Inject
    FruitResource fruitResource;

    @CommandLine.Option(names = {"-f", "--file"}, description = "name of file", defaultValue = "fruits.json")
    String fileName;

    /*Reads .json file and consoles it
    * by default fruits.json is read,
    * other files can be read by adding "-f 'filename' ".
    * eg == read -f data.json */

    @Override
    public void run() {
        fruitResource.read(fileName);
    }
}

