package me.tdvne.commandspy.command;

import me.tdvne.commandspy.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class SocialSpy extends JavaPlugin implements Listener {

    boolean SocialSpy = false;
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (label.equalsIgnoreCase("spy"))
            if (args.length == 0) {
                p.sendMessage(CC.translate("Usage: /spy <enable/disable>"));
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("enable")) {
                    if (p.hasPermission("spy.enable")) {
                        this.SocialSpy = true;
                        p.sendMessage(CC.translate("&eYou have successfully &aenabled &espy mode!"));
                    }
                } else if (args[0].equalsIgnoreCase("disable") && p.hasPermission("spy.disable")) {
                    this.SocialSpy = false;
                    p.sendMessage(CC.translate("&eYou have successfully &cdisabled &espy mode!"));
                }
            }
        return false;
    }

    @EventHandler
    public void Comando(PlayerCommandPreprocessEvent e) {
        Bukkit.getConsoleSender().sendMessage("[Console] &c" + e.getPlayer().getName() + "&e" + "executed:" + "&c" + e.getMessage());
        if (this.SocialSpy) {
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

    @EventHandler
    public void AlEntrar(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("spy.enableonjoin") && p.isOp()) {
            this.SocialSpy = true;
            p.sendMessage(CC.translate("&eYou have successfully &aenabled &espy mode!"));
        }
    }
}
