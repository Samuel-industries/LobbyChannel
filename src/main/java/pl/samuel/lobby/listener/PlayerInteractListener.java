	package pl.samuel.lobby.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import pl.samuel.lobby.Lobby;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getItemInHand();

        if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (item != null) {
                if (item.getType() == Material.getMaterial(Lobby.getInstance().cfg.getString("hotbarItem.material")) && item
                        .getItemMeta().getDisplayName().equals(Lobby.getInstance().getString("hotbarItem.displayname"))) {
                    e.setCancelled(true);
                    Lobby.getInstance().openGUI(p);
                    return;
                }
            }
        }

    }

}
