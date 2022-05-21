package me.tdvne.commandspy;

import me.tdvne.commandspy.command.SocialSpy;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("commandspy").setExecutor(new SocialSpy());
    }

    @Override
    public void onDisable() {

    }

}
