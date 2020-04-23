package com.stockminer.game.api;
/**
 * @author Amir Nazarzadeh
 */
public interface Event {
    String getPlayerMessage();
    PlayerListener getEventSender();
}
