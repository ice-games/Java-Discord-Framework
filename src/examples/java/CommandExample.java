import com.seailz.jdaframework.command.Command;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class CommandExample extends Command {
    @Override
    public void onCommand(SlashCommandInteractionEvent e) {
        e.reply("Hello World!").queue();
    }
}
