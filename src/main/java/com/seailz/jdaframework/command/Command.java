package com.seailz.jdaframework.command;

import com.seailz.jdaframework.command.annotation.CommandInfo;
import com.seailz.jdaframework.command.option.Option;
import lombok.Getter;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import java.util.ArrayList;

/**
 * Represents a JDA command
 * @author Seailz
 */
@Getter
public abstract class Command {

    private final String name;
    private final String description;
    private final ArrayList<Option> options = new ArrayList<>();

    public Command() {
        if (!this.getClass().isAnnotationPresent(CommandInfo.class))
            throw new IllegalStateException("Commands must be annotated with the CommandInfo annotation.");

        CommandInfo ann = this.getClass().getAnnotation(CommandInfo.class);

        name = ann.name();
        description = ann.description();
    }

    /**
     * Adds an option to the command
     * @param name the name of the option
     * @param description the description of the option
     * @param type the type of the option
     * @param required whether the option is required or not
     */
    public void addOption(String name, String description, OptionType type, boolean required) {
        options.add(new Option(name, description, type, required));
    }

    /**
     * Adds an option to the command
     * @param option the option to add
     */
    public void addOption(Option option) {
        options.add(option);
    }

    /**
     * Runs the command
     * @param e the event that triggered the command
     */
    public abstract void onCommand(SlashCommandInteractionEvent e);


}
