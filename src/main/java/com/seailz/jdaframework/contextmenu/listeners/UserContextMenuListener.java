package com.seailz.jdaframework.contextmenu.listeners;

import com.seailz.jdaframework.command.Command;
import com.seailz.jdaframework.contextmenu.ContextMenu;
import com.seailz.jdaframework.contextmenu.registry.ContextMenuRegistry;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * Manages the back-end logic of the user context menu
 * @author Seailz
 */
public class UserContextMenuListener extends ListenerAdapter {
    @Override
    public void onUserContextInteraction(@NotNull UserContextInteractionEvent event) {
        HashMap<String, ContextMenu> commands = ContextMenuRegistry.getInstance().getCommands();
        if (commands.containsKey(event.getName()) && commands.get(event.getName()).getOnSubmitUser() != null) {
            commands.get(event.getName()).getOnSubmitUser().accept(event);
        }
    }
}
