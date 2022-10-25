package com.seailz.jdaframework.select;

import com.seailz.jdaframework.DiscordBot;
import net.dv8tion.jda.api.events.interaction.component.GenericSelectMenuInteractionEvent;

import java.util.function.Consumer;

public class SelectMenuManager {

    /**
     * Listen for a select menu to be interacted with
     * @param id The id of the select menu
     * @param onClick The action to perform when the select menu is interacted with
     */
    public static void listen(String id, Consumer<GenericSelectMenuInteractionEvent> onClick) {
        DiscordBot.getSelectRegistry().put(id, onClick);
    }

}
