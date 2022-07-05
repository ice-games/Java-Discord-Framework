import com.seailz.jdaframework.DiscordBot;

import javax.security.auth.login.LoginException;

public class BotExample extends DiscordBot {

    public BotExample() throws LoginException, InterruptedException {
        super("token");
        registerCommands(new CommandExample());
        build();
        getJda().awaitReady();
    }
}
