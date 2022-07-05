package com.seailz.jdaframework.modals.listeners;

import com.seailz.jdaframework.modals.Modal;
import com.seailz.jdaframework.modals.controller.ModalManager;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * The event that listens for modal interactions
 * @author Seailz
 * @version 1.0
 * @since 04/07/2022 (dd/MM/yyyy)
 */
public class ModalListener extends ListenerAdapter {

    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent e){
        for (Map.Entry<Member, Modal> modalEntry : ModalManager.getModals()) {
            if (modalEntry.getValue().getId().equals(e.getModalId()) && modalEntry.getKey().getId().equals(e.getMember().getId())){
                ModalMapping[] mappings = e.getValues().toArray(new ModalMapping[0]);
                modalEntry.getValue().getOnSubmit().accept(e.getMember(), mappings, e);
            }
        }
    }

}
