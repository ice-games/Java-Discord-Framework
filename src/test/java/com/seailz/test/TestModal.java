package com.seailz.test;

import com.seailz.jdaframework.modals.Modal;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;

public class TestModal extends Modal {


    public TestModal() {
        super("test", "test");

        TextInput lol = TextInput.create("lol", "lol", TextInputStyle.SHORT).build();
        addComponent(member -> lol);
        onSubmit((member, mappings, event) -> {
            event.getTextChannel().sendMessage("asdf").queue();
        });
    }
}
