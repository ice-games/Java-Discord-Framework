package com.seailz.jdaframework;

import com.seailz.jdaframework.button.ButtonListener;
import com.seailz.jdaframework.command.Command;
import com.seailz.jdaframework.command.listener.CommandRunListener;
import com.seailz.jdaframework.command.registry.CommandRegistry;
import com.seailz.jdaframework.contextmenu.listeners.MessageContextMenuListener;
import com.seailz.jdaframework.contextmenu.listeners.UserContextMenuListener;
import com.seailz.jdaframework.contextmenu.registry.ContextMenuRegistry;
import com.seailz.jdaframework.modals.listeners.ModalListener;
import com.seailz.jdaframework.select.SelectMenuListener;
import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.GenericSelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.EntitySelectMenu;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.function.Consumer;

/**
 * Main Discord Bot Class
 * @author Seailz
 */
@Getter
@Setter
public class DiscordBot {

    @Getter
    private static DiscordBot instance;
    @Getter
    private static HashMap<String, Consumer<ButtonInteractionEvent>> buttonRegistry;

    @Getter
    private static HashMap<String, Consumer<GenericSelectMenuInteractionEvent>> selectRegistry;

    private String token;
    private JDA jda;
    private JDABuilder builder;
    private CommandRegistry registry;
    private ContextMenuRegistry contextMenuRegistry;


    public DiscordBot(String token) {
        this.token = token;
        instance = this;
        registry = new CommandRegistry();
        contextMenuRegistry = new ContextMenuRegistry();
        builder = JDABuilder.createDefault(token);

        buttonRegistry = new HashMap<>();
        selectRegistry = new HashMap<>();

        registerListeners(
                new MessageContextMenuListener(),
                new UserContextMenuListener(),
                new CommandRunListener(),
                new ModalListener(),
                new ButtonListener(),
                new SelectMenuListener()
        );
    }

    /**
     * Builds the bot and starts it
     * @return The bot instance
     * @throws LoginException If the bot could not be started
     */
    public DiscordBot build() throws LoginException {
        jda = builder.build();
        return this;
    }

    /**
     * Registers the listeners
     * @param listeners The listeners to register
     * @return The bot instance
     */
    public DiscordBot registerListeners(ListenerAdapter... listeners) {
        JDABuilder jdaBuilder = builder;
        JDA jda = this.jda;
        for (ListenerAdapter listener : listeners) {
            if (jda == null)
                jdaBuilder.addEventListeners(listener);
            else
                jda.addEventListener(listener);
        }
        return this;
    }

    /**
     * Registers the listeners
     * @param listeners The listeners to register
     * @return The bot instance
     */
    public DiscordBot registerListeners(EventListener... listeners) {
        JDABuilder jdaBuilder = builder;
        JDA jda = this.jda;
        for (EventListener listener : listeners) {
            if (jda == null)
                jdaBuilder.addEventListeners(listener);
            else
                jda.addEventListener(listener);
        }
        return this;
    }

    /**
     * Registers the commands
     * You MUST call the {@link #build()} method before calling this method
     * @param commands The commands to register
     * @return The bot instance
     */
    public DiscordBot registerCommands(Command... commands) {
        for (Command command : commands) {
            registry.registerCommand(jda, command);
        }
        return this;
    }

    /**
     * Registers commands. These commands will <b>ONLY</b> show up in the guild you register them in, and not in DMs or any other server.
     * @param guild The guild to register them for
     * @param commands The commands to register
     * @return The bot instance
     */
    public DiscordBot registerGuildCommand(Guild guild, Command... commands) {
        for (Command command : commands) {
            registry.registerGuildCommand(command, guild);
        }
        return this;
    }
}
