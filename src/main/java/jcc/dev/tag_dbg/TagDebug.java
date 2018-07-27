package jcc.dev.tag_dbg;

import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class TagDebug extends JavaPlugin implements CommandExecutor {

    @Override
    public void onLoad() {

        if (propSet(Const.PROP_LOAD))
            testTag("ONLOAD", Tag.WOOL);
    }


    @Override
    public void onEnable() {

        if (propSet(Const.PROP_ENABLE))
            testTag("ONENABLE", Tag.WOOL);

        getCommand(Const.CMD_TAGTEST).setExecutor(this);
    }


    @Override
    public boolean onCommand(final CommandSender sender, final Command command,
            final String label, final String[] args) {

        testTag("TESTDBG", Tag.WOOL);
        return true;
    }


    private boolean propSet(final String propName) {

        return System.getProperty(propName) != null;
    }


    private void testTag(final String phase, final Tag<Material> tag) {

        final Logger log = getLogger();

        log.info(" ");
        Set<Material> mats = tag.getValues();
        if (mats == null)
            log.info(() -> quickFormat(phase, "Tag set is null"));
        else if (mats.isEmpty())
            log.info(() -> quickFormat(phase, "Tag set is EMPTY"));
        else
            log.info(() -> quickFormat(phase, mats.toString()));
        log.info(" ");
    }


    private String quickFormat(final String phase, final String msg) {

        return "######## " + phase + " ######## : " + msg;
    }
}
