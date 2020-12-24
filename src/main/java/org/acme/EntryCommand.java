package com.acme.picocli;

import picocli.CommandLine.Help.Ansi;
import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.CommandLine;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands = {HelloCommand.class, GoodByeCommand.class})
public class EntryCommand {
}

@CommandLine.Command(name = "Hello", version = "CLI 1.0", mixinStandardHelpOptions = true)
class HelloCommand implements Runnable {

    @CommandLine.Option(names={"-n","--name"},description = "name for name", defaultValue = "World")
    String name;

    private final GreetingService greetingService;

    public HelloCommand(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public void run() {
        greetingService.sayHello(name);
    }
}

@CommandLine.Command(name = "goodbye", description = "Say goodbye to World!")
class GoodByeCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Goodbye World!");
    }
}

@Dependent
class GreetingService {
    void sayHello(String name) {
        System.out.println(Ansi.AUTO.string("@|bold,blue Hello " + name + "|@"));
    }
}