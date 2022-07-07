package com.seailz.jdaframework.button;

import com.seailz.jdaframework.DiscordBot;
import lombok.Getter;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.function.Consumer;

public class ButtonManager {

    public static void listen(Button button, Consumer<ButtonInteractionEvent> onClick) {
        DiscordBot.getButtonRegistry().put(button.getId(), onClick);
    }

}
