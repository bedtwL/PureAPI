package me.bedtwL.ffa.api.game;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;

@Getter
public class PureArenaSettings {
    private final Location spawnPoint;
    private final Integer heightLimit;
    private final Integer voidHeight;
    private final String kitName;
    private final String arenaName;
    private final World.Environment worldEnv;
    private final Integer inGameY;
    private final File configFile;
    private final FileConfiguration configuration;
    private final World worldInstance;
    private final ArrayList<Player> players;
    private final ArrayList<Block> placedBlock;

    public PureArenaSettings(Location spawnPoint, Integer heightLimit, Integer voidHeight, String kitName, String arenaName, World.Environment worldEnv, Integer inGameY, File configFile, FileConfiguration configuration, World worldInstance, ArrayList<Player> players, ArrayList<Block> placedBlock) {
        this.spawnPoint = spawnPoint;
        this.heightLimit = heightLimit;
        this.voidHeight = voidHeight;
        this.kitName = kitName;
        this.arenaName = arenaName;
        this.worldEnv = worldEnv;
        this.inGameY = inGameY;
        this.configFile = configFile;
        this.configuration = configuration;
        this.worldInstance = worldInstance;
        this.players = players;
        this.placedBlock = placedBlock;
    }
}
