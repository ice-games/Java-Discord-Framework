package com.seailz.jdaframework.modals.controller;

import com.seailz.jdaframework.modals.Modal;
import lombok.Getter;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.GenericSelectMenuInteractionEvent;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.ItemComponent;

import java.util.ArrayList;
import java.util.Map;

/**
 * Manages the back-end logic for the API.
 * @author Seailz
 * @version 1.0
 * @since 04/07/2022 (dd/MM/yyyy)
 */
public class ModalManager {

    @Getter
    private static final ArrayList<Map.Entry<Member, Modal>> modals = new ArrayList<>();

    /**
     * Opens the modal
     * @param modal The modal to open
     * @param member The member to show the modal to
     * @param interaction The interaction to reply to
     */
    public static void open(Modal modal, Member member, Interaction interaction) {
        ArrayList<ItemComponent> components = new ArrayList<>();
        modal.getComponents().forEach(component -> {
            components.add(component.apply(member));
        });

        net.dv8tion.jda.api.interactions.modals.Modal.Builder jdaModal = net.dv8tion.jda.api.interactions.modals.Modal.create(
                modal.getId(), modal.getTitle()
        );

        components.forEach(component -> {
            jdaModal.addActionRows(ActionRow.of(component));
        });

        if (interaction instanceof SlashCommandInteractionEvent) {
            SlashCommandInteractionEvent e = (SlashCommandInteractionEvent) interaction;
            e.replyModal(jdaModal.build()).queue();
        } else if (interaction instanceof ButtonInteractionEvent) {
            ButtonInteractionEvent e = (ButtonInteractionEvent) interaction;
            e.replyModal(jdaModal.build()).queue();
        } else if (interaction instanceof GenericSelectMenuInteractionEvent) {
            GenericSelectMenuInteractionEvent e = (GenericSelectMenuInteractionEvent) interaction;
            e.replyModal(jdaModal.build()).queue();
        } else
            throw new IllegalStateException("Interaction is not a SlashCommandInteractionEvent, SelectMenuInteractionEvent or ButtonInteractionEvent");


        modals.add(new Map.Entry<Member, Modal>() {
            @Override
            public Member getKey() {
                return member;
            }

            @Override
            public Modal getValue() {
                return modal;
            }

            @Override
            public Modal setValue(Modal value) {
                return null;
            }
        });

    }
}
