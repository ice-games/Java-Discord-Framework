package com.seailz.test;

import com.seailz.jdaframework.DiscordBot;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class TestBot extends DiscordBot {

    public static void main(String[] args) throws LoginException {
        new TestBot();
    }
    public TestBot() throws LoginException {
        super("token");
        build();

        registerCommands(new TestCommand());
    }
}
