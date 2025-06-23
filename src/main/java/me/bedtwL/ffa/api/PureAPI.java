package me.bedtwL.ffa.api;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class PureAPI {
    @Getter
    private static JavaPlugin plugin;
    public static void setInstance(JavaPlugin instance) {
        if (plugin==null)
            plugin=instance;
    }
    public static Integer getAPIVer() {
        return 1;
    }
}
