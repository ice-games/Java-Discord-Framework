import com.seailz.jdaframework.contextmenu.ContextMenu;
import net.dv8tion.jda.api.interactions.commands.Command;

public class MessageContextMenuExample extends ContextMenu {

    public MessageContextMenuExample() {
        super("Context Menu", Command.Type.MESSAGE);
        onSubmitMessage(e -> {
            e.reply("Hello World!").queue();
        });

        // Just call a new instance of this class after your build method in your bot class
    }

}
