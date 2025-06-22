package me.bedtwL.ffa.api;

import java.util.UUID;

public interface EffectAddon {
    String getName();
    String getAuthor();
    UUID authorUUID = null;
    void onEnable();
    default void onFirstLoad() {
    }
    void onDisable();
}
