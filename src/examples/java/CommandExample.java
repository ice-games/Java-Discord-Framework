import com.seailz.jdaframework.command.Command;
import com.seailz.jdaframework.command.annotation.CommandInfo;
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
