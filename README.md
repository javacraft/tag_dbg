# Spigot 1.13 Build 1690 Tag Test

This simple test jig plugin retrieves `Material` values associated with the `wool` tag
via `org.bukkit.Tag.WOOL` and the more generic method `Bukkit.getTag()`
to demonstrate that said values are not loaded during the plugin load phase
(i.e. `onLoad()`), but are accessible during the plugin enable phase
(i.e. `onEnable()`).

It further demonstrates that if any part of the `org.Bukkit.Tag` interface
is loaded by a class loader during a plugin's load phase, the convenience
instances it defines (e.g. `WOOL`, `PLANKS`, etc.) will continue to have no
values, which is to be expected.

All in all, it appears that the Tag Registry is not fully initialized or
populated until some time between the plugin load and enable phases.

This plugin can be used to evaluate tag values during plugin load and enable
phases and via a simple command. The JVM arguments `-Dtag-load` and `-Dtag-enable`
can be used to select the phase in which to evaluate tag values. For example,
to evaluate tags during load and enable, use.

`java -Dtag-load -Dtag-enable -jar spigot-1.13-R0.1-SNAPSHOT.jar`

To only evaluate during the plugin load phase, use:

`java -Dtag-load -jar spigot-1.13-R0.1-SNAPSHOT.jar`

Tag values can be evaluated from the command line via `tagtest`.

