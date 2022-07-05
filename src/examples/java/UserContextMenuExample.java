import com.seailz.jdaframework.contextmenu.ContextMenu;
import net.dv8tion.jda.api.interactions.commands.Command;

public class UserContextMenuExample extends ContextMenu {

    public UserContextMenuExample() {
        super("Context Menu", Command.Type.USER);
        onSubmitUser(e -> {
            e.reply("Hello World!").queue();
        });

        // Just call a new instance of this class after your build method in your bot class
    }

}