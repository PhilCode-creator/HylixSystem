package eu.hylix.bungeecord.command;

import eu.hylix.bungeecord.BungeeCordSystem;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_Find extends Command {

    

    public CMD_Find(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(sender instanceof ProxiedPlayer)) {sender.sendMessage(BungeeCordSystem.getInstance().noPlayer); return;}
        ProxiedPlayer player = (ProxiedPlayer) sender;
        if(!player.hasPermission("hylix.find") || !player.hasPermission("hylix.*")) {sender.sendMessage(BungeeCordSystem.getInstance().noPermission); return;}

        if(args.length == 1) {
            ProxiedPlayer target = BungeeCord.getInstance().getPlayer(args[0]);
            if(target != null) {
                player.sendMessage(new TextComponent(BungeeCordSystem.getInstance().prefix + "§9Der Spieler §e" + target.getName() + " §9ist auf §d" + target.getServer().getInfo().getName()));
                TextComponent message = new TextComponent("§aKlicke hier um zu ihm zugelangen");
                message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/Jumpto " + target.getName()));
                player.sendMessage(message);
                return;
            } else {
                player.sendMessage(new TextComponent(BungeeCordSystem.getInstance().prefix + "§cDieser Spieler ist nicht auf dem Netzwerk"));
                return;
            }
        } else {
            player.sendMessage(new TextComponent(BungeeCordSystem.getInstance().prefix + "§cVerwendung: /find <Spieler>"));
        }
    }
}
