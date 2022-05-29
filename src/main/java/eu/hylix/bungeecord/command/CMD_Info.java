package eu.hylix.bungeecord.command;

import eu.hylix.bungeecord.BungeeCordSystem;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_Info extends Command {

    public CMD_Info(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(sender instanceof ProxiedPlayer)) {sender.sendMessage(BungeeCordSystem.getInstance().noPlayer); return;}
        ProxiedPlayer player = (ProxiedPlayer) sender;
        if(!player.hasPermission("hylix.info") || !player.hasPermission("hylix.*")) {sender.sendMessage(BungeeCordSystem.getInstance().noPermission); return;}
        if(args.length == 0) {
            player.sendMessage(new TextComponent("§7▛ §c§lSpieler Informationen §7§l▜"));
            player.sendMessage(new TextComponent("§eName: " + player.getName()));
            player.sendMessage(new TextComponent("§dUUID: " + player.getUniqueId().toString()));
            player.sendMessage(new TextComponent("§9IP: " + player.getSocketAddress().toString()));
            player.sendMessage(new TextComponent("§7▙ §c§lSpieler Informationen §7§l▟"));
            return;
        } else if(args.length == 1) {
            ProxiedPlayer target = BungeeCord.getInstance().getPlayer(args[0]);
            if(target != null) {
                if(!target.hasPermission("hylix.iphidden")) {
                    player.sendMessage(new TextComponent("§7▛ §c§lSpieler Informationen §7§l▜"));
                    player.sendMessage(new TextComponent("§eName: §f" + target.getName()));
                    player.sendMessage(new TextComponent("§dUUID: §f" + target.getUniqueId().toString()));
                    player.sendMessage(new TextComponent("§9IP: §f" + target.getSocketAddress().toString().replace("/", "")));
                    player.sendMessage(new TextComponent("§7▙ §c§lSpieler Informationen §7§l▟"));
                    return;
                } else {
                    player.sendMessage(new TextComponent("§7▛ §c§lSpieler Informationen §7§l▜"));
                    player.sendMessage(new TextComponent("§eName: §f" + target.getName()));
                    player.sendMessage(new TextComponent("§dUUID: §f" + target.getUniqueId().toString()));
                    player.sendMessage(new TextComponent("§9IP: §k127.0.0.1"));
                    player.sendMessage(new TextComponent("§7▙ §c§lSpieler Informationen §7§l▟"));
                    return;
                }
            } else {
                player.sendMessage(new TextComponent(BungeeCordSystem.getInstance().prefix + "§cDieser Spieler ist nicht auf dem Netzwerk"));
                return;
            }
        } else {
            player.sendMessage(new TextComponent(BungeeCordSystem.getInstance().prefix + "§cVerwendung: /info <Spieler>"));
            return;
        }
    }
}
