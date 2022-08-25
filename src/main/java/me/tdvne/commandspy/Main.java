package me.tdvne.commandspy;

import me.tdvne.commandspy.command.SocialSpy;
import me.tdvne.commandspy.events.CommandPreProcess;
import me.tdvne.commandspy.events.PlayerJoin;
import me.tdvne.commandspy.util.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin implements Listener {
    private static Main instance;

    private final List<Player> spyingPlayers = new ArrayList<>();

    public void onEnable() {
        instance = this;
        this.getServer().getPluginManager().registerEvents(new CommandPreProcess(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        this.getCommand("spy").setExecutor(new SocialSpy());
        System.out.println("[CommandSpy] This plugin has successfully enabled.");
    }

    public void onDisable() {
        System.out.println("[CommandSpy] This plugin has successfully disabled");
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().trim().equalsIgnoreCase("commandspy")) {
            e.getPlayer().sendMessage(CC.translate("&4&m--*----------------*--"));
            e.getPlayer().sendMessage(CC.translate("&4&lCommand Spy"));
            e.getPlayer().sendMessage(CC.translate(" &c&l┃ &fAuthor: &ctdvne"));
            e.getPlayer().sendMessage(CC.translate(" &c&l┃ &fDiscord: &ctdvne#0001"));
            e.getPlayer().sendMessage(CC.translate(" &c&l┃ &fVersion: &cv1.0"));
            e.getPlayer().sendMessage(CC.translate("&4&m--*----------------*--"));
            e.setCancelled(true);
        }
    }

    // Getters and Setters
    public List<Player> getSpyingPlayers() {
        return spyingPlayers;
    }
    public void addSpyingPlayer(Player p) {
        if (!this.spyingPlayers.contains(p)) {
            this.spyingPlayers.add(p);
        }
    }
    public static Main getInstance() {
        return instance;
    }
}
