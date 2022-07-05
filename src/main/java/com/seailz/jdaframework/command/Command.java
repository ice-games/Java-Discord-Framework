package com.seailz.jdaframework.command;

import com.seailz.jdaframework.command.annotation.CommandInfo;
import com.seailz.jdaframework.command.option.Option;
import lombok.Getter;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import java.util.ArrayList;

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

    public void addOption(String name, String description, OptionType type, boolean required) {
        options.add(new Option(name, description, type, required));
    }

    public void addOption(Option option) {
        options.add(option);
    }

    public abstract void onCommand(SlashCommandInteractionEvent e);


}
