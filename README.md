# Java-Discord-Framework
Designed to make developing bots faster and simpler!
 
## Setting up your main class
In your main class, you need to extend `DiscordBot`, like this:
```java
import javax.security.auth.login.LoginException;

public class BotExample extends DiscordBot {

    public BotExample() throws LoginException, InterruptedException {
        super("token");
        registerCommands(new CommandExample());
        build();
        getJda().awaitReady();
    }
}
```

## Commands
Making commands with this framework is really easy, here's an example:

```java
import com.seailz.jdaframework.command.Command;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class CommandExample extends Command {
    @Override
    public void onCommand(SlashCommandInteractionEvent e) {
        e.reply("Hello World!").queue();
    }
}
```
See? Really easy!
Now all you need to do is register it in your main class, like this:
```java
registerCommands(
    new CommandExample()
);
```

## Modals

### QUICK DISCALIMER
You **must** include this line in your main class:
```java
        jdaInstanceVariable.addEventListener(new ModalListener());
```

If you don't, it will not work.
I may try to find a way around this in the future, but for now, that's how it is.

```java
public class ModalExample extends Modal {

    public ModalExample() {
        super("Questions", "age-question"); // The title and the ID
        TextInput input = TextInput.create("age", "How old are you?", TextInputStyle.SHORT)
                .setMaxLength(2).build(); // The input fields

        addComponent(member -> input); // adds the component to the modal
        onSubmit((member, mappings, event) -> {
            event.reply("Thanks for submitting your age! We received **" + mappings[0].getAsString() + "** years old.").queue();
        }); // what to do when the modal is submitted
    }
}
```

Here's an example of opening a modal for a user:

```java
public class ModalCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!event.getName().equals("modal"))
            return;
        ModalExample testModal = new ModalExample();
        testModal.open(event.getMember(), event);
    }

}
```
