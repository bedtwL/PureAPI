package me.bedtwL.ffa.api;

import java.util.UUID;

public interface EffectAddon {
    default Integer getAPIVer() {
        return 0; // Current: 1, You must override or your addon won't work
    }
    String getName();
    String getAuthor();
    UUID authorUUID();

    void onEnable();
    default void onFirstLoad() {
    }
    void onDisable();
}
