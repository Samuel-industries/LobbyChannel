package pl.samuel.lobby.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import pl.samuel.lobby.ping.ServerInfo;
import pl.samuel.lobby.Lobby;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) return;

        if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', Lobby.getInstance().cfg.getString("inventory.title")))) {
         e.setCancelled(true);
         
        if (e.getCurrentItem().getType().equals(Material.getMaterial(Lobby.getInstance().cfg.getString("layouts.online.material")))) {
        for (ServerInfo servers : Lobby.getInstance().servers.values()) {
        if (e.getSlot() == servers.getSlot()) {
        if (servers.isOnline()) {
        if (servers.getServerName().equals(Lobby.getInstance().currentServer)) {
        p.closeInventory();
        p.sendMessage(Lobby.getInstance().getString("messages.prefix") + Lobby.getInstance().getString("messages.server_already_connected").replace("%server%", servers.getDisplayName()));
        
        } else {
        p.closeInventory();
        p.sendMessage(Lobby.getInstance().getString("messages.prefix") + Lobby.getInstance().getString("messages.server_connect").replace("%server%", servers.getDisplayName()));
        Lobby.getInstance().sendToServer(p, servers.getServerName());
                    }
        } else {
       p.closeInventory();
        p.sendMessage(Lobby.getInstance().getString("messages.prefix") + Lobby.getInstance().getString("messages.server_offline").replace("%server%", servers.getDisplayName()));
                        }

                    }
                }
            }
        }

    }
}
