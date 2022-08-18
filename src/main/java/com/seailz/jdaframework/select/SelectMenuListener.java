package com.seailz.jdaframework.select;

import com.seailz.jdaframework.DiscordBot;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class SelectMenuListener extends ListenerAdapter {
    @Override
    public void onSelectMenuInteraction(@NotNull SelectMenuInteractionEvent event) {
        if (DiscordBot.getSelectRegistry().containsKey(event.getSelectMenu().getId())) {
            DiscordBot.getSelectRegistry().get(event.getSelectMenu().getId()).accept(event);
        }
    }
}
