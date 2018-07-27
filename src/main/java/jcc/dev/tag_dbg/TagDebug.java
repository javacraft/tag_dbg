package jcc.dev.tag_dbg;

import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class TagDebug extends JavaPlugin implements CommandExecutor {

    @Override
    public void onLoad() {
        if (propSet(Const.PROP_LOAD))
            evaluateTagMats("ONLOAD");
    }


    @Override
    public void onEnable() {
        if (propSet(Const.PROP_ENABLE))
            evaluateTagMats("ONENABLE");

        getCommand(Const.CMD_TAGTEST).setExecutor(this);
    }


    @Override
    public boolean onCommand(final CommandSender sender, final Command command,
            final String label, final String[] args) {

        evaluateTagMats("TESTDBG");
        return true;
    }


    private void evaluateTagMats(final String phase) {
        testTagMats(phase + " - Bukkit.getTag()", getTagMats("wool"));
        testTagMats(phase + " - Tag.WOOL.getValues", Tag.WOOL.getValues());
    }


    private boolean propSet(final String propName) {
        return System.getProperty(propName) != null;
    }


    private Set<Material> getTagMats(final String tag) {
        return Bukkit.getTag(
                Const.REGISTRY,
                NamespacedKey.minecraft(tag),
                Material.class).getValues();
    }


    private void testTagMats(final String msg, final Set<Material> mats) {
        final Logger log = getLogger();

        log.info(Const.HEADER);
        if (mats == null)
            log.info(() -> quickFormat(msg, "Tag set is null"));
        else if (mats.isEmpty())
            log.info(() -> quickFormat(msg, "Tag set is EMPTY"));
        else
            log.info(() -> quickFormat(msg, mats.toString()));
        log.info(Const.HEADER);
    }


    private String quickFormat(final String phase, final String msg) {
        return "######## " + phase + " ######## : " + msg;
    }
}
