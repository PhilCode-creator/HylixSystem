package eu.hylix.bungeecord.command;

import eu.hylix.bungeecord.BungeeCordSystem;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_JumpTo extends Command {

    public CMD_JumpTo(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(sender instanceof ProxiedPlayer)) {sender.sendMessage(BungeeCordSystem.getInstance().noPlayer); return;}
        ProxiedPlayer player = (ProxiedPlayer) sender;
        if(!player.hasPermission("hylix.jumpto") || !player.hasPermission("hylix.*")) {sender.sendMessage(BungeeCordSystem.getInstance().noPermission); return;}

        if(args.length == 1) {
            ProxiedPlayer target = BungeeCord.getInstance().getPlayer(args[0]);
            if(target != null) {
                ServerInfo serverInfo = target.getServer().getInfo();
                if(player.getServer().getInfo().getName() == serverInfo.getName()) {
                    player.sendMessage(new TextComponent(BungeeCordSystem.getInstance().prefix + "§cBereits auf dem selben Server"));
                    return;
                } else {
                    player.connect(serverInfo);
                    player.sendMessage(new TextComponent(BungeeCordSystem.getInstance().prefix + "§fSende zu: " + target.getName()));
                }


                return;
            } else {
                player.sendMessage(new TextComponent(BungeeCordSystem.getInstance().prefix + "§cDieser Spieler ist nicht auf dem Netzwerk"));
                return;
            }
        } else {
            player.sendMessage(new TextComponent(BungeeCordSystem.getInstance().prefix + "§cVerwendung: /JumpTo <Spieler>"));
            return;
        }

    }
}
