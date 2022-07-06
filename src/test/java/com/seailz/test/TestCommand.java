package com.seailz.test;

import com.seailz.jdaframework.command.Command;
import com.seailz.jdaframework.command.annotation.CommandInfo;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

@CommandInfo(
        name = "test",
        description = "Test command"
)
public class TestCommand extends Command {
    @Override
    public void onCommand(SlashCommandInteractionEvent e) {
        e.reply("hi").queue();
    }
}
