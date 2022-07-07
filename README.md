#### NOTE: This project will contiue to be updated, and you can find all upcoming features in https://github.com/seailz/Java-Discord-Framework/issues/
#### I'm open to suggestions & prs! :)

# Java-Discord-Framework
Designed to make developing bots faster and simpler!

## Maven
```xml
<repository>
	<id>jitpack.io</id>
	<url>https://jitpack.io</url>
</repository>
```

```xml
<dependency>
	<groupId>com.github.ice-games</groupId>
	<artifactId>java-discord-framework</artifactId>
	<version>1.2</version>
</dependency>
 ```
 
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

@CommandInfo(
  name = "epiccommand",
  description = "This is such an epic command!"
)
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

## Context Menus
### Message Context Menus
```java
public class MessageContextMenuExample extends ContextMenu {

    public MessageContextMenuExample() {
        super("Context Menu", Command.Type.MESSAGE);
        onSubmitMessage(e -> {
            e.reply("Hello World!").queue();
        });

        // Just call a new instance of this class after your build method in your bot class
    }

}
```

In your main class, all you need to do is call a new instance of this class, like this:
```java
new MessageContextMenuExample();
```

### User context menus
The same as before, but just replace `onSubmitMessage`, with `onSubmitUser`.

## Modals

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

## Buttons
```java
ButtonManager.listen(Button.secondary("epic-button", "Don't you agree?"), event -> {
       event.reply("You clicked the epic button!").queue();
});
```
