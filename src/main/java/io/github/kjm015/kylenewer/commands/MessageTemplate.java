package io.github.kjm015.kylenewer.commands;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MessageTemplate {

    private static final List<String> verbsMotionPast = new ArrayList<String>() {{
            add("drove");
            add("walked");
            add("commuted");
            add("flew");
            add("rode");
            add("glided");
            add("strolled over");
            add("sauntered over");
            add("");
        }
    };

}
