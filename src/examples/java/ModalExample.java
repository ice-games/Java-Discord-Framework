import com.seailz.jdaframework.modals.Modal;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;

public class ModalExample extends Modal {

    public ModalExample() {
        super("Hello World", "hello-world-modal");
        addComponent(member -> TextInput.create("name", "What is your name?", TextInputStyle.SHORT).build());
        onSubmit((member, mappings, interaction) -> {
            interaction.reply("Hello " + mappings[0].getAsString() + "!").queue();
        });

        // Use the #open method to open the modal
    }

}
