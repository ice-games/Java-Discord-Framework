package com.seailz.jdaframework.contextmenu.listeners;

import com.seailz.jdaframework.contextmenu.ContextMenu;
import com.seailz.jdaframework.contextmenu.registry.ContextMenuRegistry;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * Manages the back-end logic of the message context menu
 * @author Seailz
 */
public class MessageContextMenuListener extends ListenerAdapter {
    @Override
    public void onMessageContextInteraction(@NotNull MessageContextInteractionEvent event) {
        HashMap<String, ContextMenu> commands = ContextMenuRegistry.getInstance().getCommands();
        if (commands.containsKey(event.getName()) && commands.get(event.getName()).getOnSubmitMessage() != null) {
            commands.get(event.getName()).getOnSubmitMessage().accept(event);
        }
    }
}
