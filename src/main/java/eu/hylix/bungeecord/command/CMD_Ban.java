package eu.hylix.bungeecord.command;

import eu.hylix.bungeecord.BungeeCordSystem;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class CMD_Ban extends Command {


    public CMD_Ban(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(sender instanceof ProxiedPlayer)) {sender.sendMessage(BungeeCordSystem.getInstance().noPlayer); return;}
        ProxiedPlayer player = (ProxiedPlayer) sender;
        if(!player.hasPermission("hylix.ban") || !player.hasPermission("hylix.*")) {sender.sendMessage(BungeeCordSystem.getInstance().noPermission); return;}


    }
}
