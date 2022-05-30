package eu.hylix.bungeecord.command;

import eu.hylix.bungeecord.BungeeCordSystem;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_Kick extends Command {
    public CMD_Kick(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(sender instanceof ProxiedPlayer)) {sender.sendMessage(BungeeCordSystem.getInstance().noPlayer); return;}
        ProxiedPlayer player = (ProxiedPlayer) sender;
        if(!player.hasPermission("hylix.kick") || !player.hasPermission("hylix.*")) {sender.sendMessage(BungeeCordSystem.getInstance().noPermission); return;}

        if(args.length >= 2) {
            String reason = "";
            for (int i = 0; i < args.length; i++) {
                reason = reason + args[1] + " ";
            }
        } else {
            player.sendMessage(new TextComponent(BungeeCordSystem.getInstance().prefix + "§cVerwendung: /kick <Spieler> [Grund]"));
            return;
        }
    }
}
