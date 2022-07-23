package com.seailz.jdaframework.command.registry;

import com.seailz.jdaframework.command.Command;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.restaction.CommandCreateAction;

import java.util.HashMap;

@Getter
public class CommandRegistry {

    private final HashMap<String, Command> commands;
    @Getter
    private static CommandRegistry instance;

    public CommandRegistry() {
        commands = new HashMap<>();
        instance = this;
    }

    public void registerCommand(JDA jda, Command command) {
        if (commands.containsValue(command)) return;
        if (command.getOptions().isEmpty()) {
            jda.upsertCommand(command.getName(), command.getDescription()).queue();
        } else {
            CommandCreateAction action = jda.upsertCommand(command.getName(), command.getDescription());
            command.getOptions().forEach(option -> {
                action.addOption(option.getType(), option.getName(), option.getDescription(), option.isRequired());
            });
            action.queue();
        }
        commands.put(command.getName(), command);
    }

}
