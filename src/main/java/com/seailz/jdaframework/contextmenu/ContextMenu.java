package com.seailz.jdaframework.contextmenu;

import com.seailz.jdaframework.DiscordBot;
import lombok.Getter;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.function.Consumer;

/**
 * Create ContextMenus with ease!
 * @author Seailz
 */
@Getter
public class ContextMenu {

    private Consumer<UserContextInteractionEvent> onSubmitUser;
    private Consumer<MessageContextInteractionEvent> onSubmitMessage;

    public ContextMenu(String name, Command.Type type) {
        DiscordBot.getInstance().getJda().updateCommands().addCommands(
                Commands.context(type, name)
        ).queue();
    }

    /**
     * If you're using a User context menu
     * @param consumer the consumer to run when the user submits the context menu
     */
    public void onSubmitUser(Consumer<UserContextInteractionEvent> consumer) {
        if (onSubmitMessage != null) return;
        onSubmitUser = consumer;
    }

    /**
     * If you're using a Message context menu
     * @param consumer the consumer to run when the message submits the context menu
     */
    public void onSubmitMessage(Consumer<MessageContextInteractionEvent> consumer) {
        if (onSubmitUser != null) return;
        onSubmitMessage = consumer;
    }

}
