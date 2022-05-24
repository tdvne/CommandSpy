package me.tdvne.commandspy.events;

import me.tdvne.commandspy.Main;
import me.tdvne.commandspy.util.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("spy.enableonjoin") && p.isOp()) {
            Main.getInstance().addSpyingPlayer(p);
            p.sendMessage(CC.translate("&eYou have successfully &aenabled &espy mode!"));
        }
    }

}
