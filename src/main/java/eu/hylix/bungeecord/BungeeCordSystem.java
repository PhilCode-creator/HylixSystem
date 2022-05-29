package eu.hylix.bungeecord;

import eu.hylix.bungeecord.command.CMD_Find;
import eu.hylix.bungeecord.command.CMD_Info;
import eu.hylix.bungeecord.command.CMD_JumpTo;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class BungeeCordSystem extends Plugin {


    //Startup Message
    String activeString = "§7==========[§6Hylix Management§7]==========]\n\n§fStatus: §aAktiviert\n\n§dVersion: " + this.getDescription().getVersion() + "\n\n§7==========[§6Hylix Management§7]==========";
    String inactiveString = "§7==========[§6Hylix Management§7]==========]\n\n§fStatus: §cDeaktiviert\n\n§dVersion: " + this.getDescription().getVersion() + "\n\n§7==========[§6Hylix Management§7]==========";

    //variables
    private static BungeeCordSystem instance;

    public String prefix = "§6§lHylix §7§l│ §r";
    public TextComponent noPlayer = new TextComponent(prefix + "§cDazu musst du ein Spieler sein!");
    public TextComponent noPermission = new TextComponent(prefix + "§cDazu hast du keine Rechte!");

    public static BungeeCordSystem getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        BungeeCord.getInstance().getConsole().sendMessage(new TextComponent(activeString));
        registerCommands();
        registerEvents();
    }

    private void registerCommands() {
        PluginManager pluginManager = BungeeCord.getInstance().getPluginManager();
        pluginManager.registerCommand(this, new CMD_Find("Find"));
        pluginManager.registerCommand(this, new CMD_Info("Info"));
        pluginManager.registerCommand(this, new CMD_JumpTo("JumpTo"));
    }

    private void registerEvents() {
    }

    @Override
    public void onDisable() {
        instance = this;
        BungeeCord.getInstance().getConsole().sendMessage(new TextComponent(inactiveString));
    }



}
