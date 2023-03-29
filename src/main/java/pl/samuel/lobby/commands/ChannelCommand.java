package pl.samuel.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.samuel.lobby.Lobby;

public class ChannelCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("core.admin")) {
            sender.sendMessage(Lobby.getInstance().getString("messages.no_permission"));
            return true;
        }
                if (!(sender instanceof Player)) {
                    sender.sendMessage("§cTo polecenie jest dostępne tylko dla graczy");
                    return true;
                }
                final Player player = (Player) sender;
                Lobby.getInstance().openGUI(player);
                return true;
            }
}