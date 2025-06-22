package me.bedtwL.ffa.api;

import java.util.UUID;

public interface EffectAddon {
    String getName();
    String getAuthor();
    default UUID authorUUID() {
        return UUID.fromString("f6edfcd8-f6b8-4e57-9367-8648953eaae2");
    }
    void onEnable();
    default void onFirstLoad() {
    }
    void onDisable();
}
