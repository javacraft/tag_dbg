package jcc.dev.tag_dbg;

import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.plugin.java.JavaPlugin;

public class TagDebug extends JavaPlugin {

    @Override
    public void onLoad() {
        testTag("ONLOAD", Tag.WOOL);
    }


    @Override
    public void onEnable() {
        testTag("ONENABLE", Tag.WOOL);
    }


    private void testTag(final String phase, final Tag<Material> tag) {
        final Logger log = getLogger();

        Set<Material> mats = tag.getValues();
        if (mats == null)
            log.info(() -> quickFormat(phase, "Tag set is null"));
        else if (mats.isEmpty())
            log.info(() -> quickFormat(phase, "Tag set is EMPTY"));
        else
            log.info(() -> quickFormat(phase, mats.toString()));

    }


    private String quickFormat(final String phase, final String msg) {
        return "######## " + phase + " ######## : " + msg;
    }
}
