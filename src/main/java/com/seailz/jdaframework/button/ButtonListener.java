package com.seailz.jdaframework.button;

import com.seailz.jdaframework.DiscordBot;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ButtonListener extends ListenerAdapter {
    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if (DiscordBot.getButtonRegistry().containsKey(event.getButton().getId())) {
            DiscordBot.getButtonRegistry().get(event.getButton().getId()).accept(event);
        }
    }
}
