package com.seailz.jdaframework.command.listener;

import com.seailz.jdaframework.DiscordBot;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class CommandRunListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (DiscordBot.getInstance().getRegistry().getCommands().containsKey(event.getName())) {
            DiscordBot.getInstance().getRegistry().getCommands().get(event.getName()).onCommand(event);
        }
    }
}
