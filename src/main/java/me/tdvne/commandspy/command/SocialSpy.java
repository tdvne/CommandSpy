package me.tdvne.commandspy.command;

import me.tdvne.commandspy.Main;
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

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (label.equalsIgnoreCase("spy"))
            if (args.length == 0) {
                p.sendMessage(CC.translate("Usage: /spy <enable/disable>"));
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("enable")) {
                    if (p.hasPermission("spy.enable")) {
                        Main.getInstance().addSpyingPlayer(p);
                        p.sendMessage(CC.translate("&eYou have successfully &aenabled &espy mode!"));
                    }
                } else if (args[0].equalsIgnoreCase("disable") && p.hasPermission("spy.disable")) {
                    Main.getInstance().getSpyingPlayers().remove(p);
                    p.sendMessage(CC.translate("&eYou have successfully &cdisabled &espy mode!"));
                }
            }
        return false;
    }


}
