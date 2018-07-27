package jcc.dev.tag_dbg;

import com.google.common.base.Strings;

public class Const {
    public static final String CMD_TAGTEST = "tagtest";
    public static final String PROP_LOAD   = "tag-load";
    public static final String PROP_ENABLE = "tag-enable";
    public static final String REGISTRY    = "blocks";
    public static final String HEADER      = Strings.repeat("#", 50);


    private Const() {
        throw new IllegalStateException("Utility class");
    }
}
