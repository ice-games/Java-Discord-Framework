package com.seailz.jdaframework.contextmenu.registry;

import com.seailz.jdaframework.command.Command;
import com.seailz.jdaframework.contextmenu.ContextMenu;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.requests.restaction.CommandCreateAction;

import java.util.HashMap;

@Getter
public class ContextMenuRegistry {

    private final HashMap<String, ContextMenu> commands;
    @Getter
    private static ContextMenuRegistry instance;

    public ContextMenuRegistry() {
        commands = new HashMap<>();
        instance = this;
    }
}
