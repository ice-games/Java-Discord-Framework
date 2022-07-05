package com.seailz.jdaframework.command.option;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.interactions.commands.OptionType;

@Data
@RequiredArgsConstructor
public class Option {

    private final String name;
    private final String description;
    private final OptionType type;
    private final boolean required;

}
