package com.seailz.jdaframework.select;

import com.seailz.jdaframework.DiscordBot;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;

import java.util.function.Consumer;

public class SelectMenuManager {

    public static void listen(String id, Consumer<SelectMenuInteractionEvent> onClick) {
        DiscordBot.getSelectRegistry().put(id, onClick);
    }

}
