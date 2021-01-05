package org.acme;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.CommandLine;

/*When multiple classes have the picocli.CommandLine.Command annotation,
then one of them needs to be also annotated with io.quarkus.picocli.runtime.annotations.TopCommand  */
@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands = {GetFruits.class, AddFruit.class})

public class EntryCommand {
}