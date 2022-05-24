package me.tdvne.commandspy.events;

import me.tdvne.commandspy.Main;
import me.tdvne.commandspy.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandPreProcess implements Listener {

    @EventHandler
    public void Comando(PlayerCommandPreprocessEvent e) {
        Bukkit.getConsoleSender().sendMessage("[Console] &c" + e.getPlayer().getName() + "&e" + "executed:" + "&c" + e.getMessage());
        if (Main.getInstance().getSpyingPlayers().contains(e.getPlayer())) {
            byte b;
            int i;
            Player[] arrayOfPlayer;
            for (i = (arrayOfPlayer = Bukkit.getOnlinePlayers().toArray(new Player[0])).length, b = 0; b < i; ) {
                Player p = arrayOfPlayer[b];
                if (p.hasPermission("spy.admin"))
                    p.sendMessage(CC.translate("&c" + e.getPlayer().getName() +  "&eexecuted:&c" + e.getMessage()));
                b++;
            }
        } else {
            e.setCancelled(true);
        }
    }

}
