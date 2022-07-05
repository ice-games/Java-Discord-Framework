package com.seailz.jdaframework;

import com.seailz.jdaframework.command.Command;
import com.seailz.jdaframework.command.registry.CommandRegistry;
import com.seailz.jdaframework.contextmenu.ContextMenu;
import com.seailz.jdaframework.contextmenu.registry.ContextMenuRegistry;
import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.HashMap;

/**
 * Main Discord Bot Class
 * @author Seailz
 */
@Getter
@Setter
public class DiscordBot {

    @Getter
    private static DiscordBot instance;
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
        for (ListenerAdapter listener : listeners) {
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
        for (EventListener listener : listeners) {
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
}
