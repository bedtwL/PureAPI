package me.bedtwL.ffa.api;

public interface EffectAddon {
    String getName();
    String getAuthor();
    void onEnable();
    default void onFirstLoad() {
    }
    void onDisable();
}
