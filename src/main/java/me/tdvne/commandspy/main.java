package me.tdvne.commandspy;

import me.tdvne.commandspy.command.SocialSpy;
import me.tdvne.commandspy.util.CC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
    private static main instance;

    public static main getInstance() {
        return instance;
    }
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("spy").setExecutor(new SocialSpy());
        System.out.println("[CommandSpy] This plugin has successfully enabled.");
    }

    public void onDisable() {
        System.out.println("[CommandSpy] This plugin has successfully disabled");
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().trim().equalsIgnoreCase("/commandspy")) {
            e.getPlayer().sendMessage(CC.translate("&4&m--*----------------*--"));
            e.getPlayer().sendMessage(CC.translate("&4&lCommand Spy"));
            e.getPlayer().sendMessage(CC.translate(" &c&l┃ &fAuthor: &ctdvne"));
            e.getPlayer().sendMessage(CC.translate(" &c&l┃ &fDiscord: &ctdvne#0001"));
            e.getPlayer().sendMessage(CC.translate(" &c&l┃ &fVersion: &cv1.0"));
            e.getPlayer().sendMessage(CC.translate("&4&m--*----------------*--"));
            e.setCancelled(true);
        }
    }
}