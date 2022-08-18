package com.seailz.jdaframework.modals;

import com.seailz.jdaframework.modals.controller.ModalManager;
import com.seailz.jdaframework.utils.TriConsumer;
import lombok.Getter;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * Manages the front end logic for the API.
 * Extend this class to create your own modals.
 *
 * @author Seailz
 * @version 1.0
 * @since 04/07/2022 (dd/MM/yyyy)
 */
@Getter
public class Modal {

    private final String title;
    private final String id;
    private final ArrayList<Function<Member, ItemComponent>> components = new ArrayList<>();
    private TriConsumer<Member, ModalMapping[], ModalInteractionEvent> onSubmit;


    /**
     * Creates a new Modal instance (you must extend this class, don't create an instance of this class!!)
     * @param title The title of the modal
     * @param id The id of the modal
     */
    public Modal(String title, String id) {
        this.title = title;
        this.id = id;
    }

    /**
     * Adds a component to the modal.
     * @param component The component to add.
     */
    public void addComponent(Function<Member, ItemComponent> component) {
        components.add(component);
    }

    /**
     * Opens the modal
     * @param member The member to show the modal to
     * @param interaction The interaction to reply to
     */
    public void open(Member member, ButtonInteractionEvent interaction) {
        ModalManager.open(this, member, interaction);
    }

    /**
     * Opens the modal
     * @param member The member to show the modal to
     * @param interaction The interaction to reply to
     */
    public void open(Member member, SlashCommandInteractionEvent interaction) {
        ModalManager.open(this, member, interaction);
    }

    /**
     * Opens the modal
     * @param member The member to show the modal to
     * @param interaction The interaction to reply to
     */
    public void open(Member member, SelectMenuInteractionEvent interaction) {
        ModalManager.open(this, member, interaction);
    }

    /**
     * Selects the method to be called when the modal is submitted.
     * @param onSubmit The method to be called when the modal is submitted.
     */
    public void onSubmit(TriConsumer<Member, ModalMapping[], ModalInteractionEvent> onSubmit) {
        this.onSubmit = onSubmit;
    }
}
