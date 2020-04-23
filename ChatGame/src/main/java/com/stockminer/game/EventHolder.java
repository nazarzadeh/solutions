package com.stockminer.game;

import com.stockminer.game.api.Event;
import com.stockminer.game.api.PlayerListener;

/**
 * @author Amir Nazarzadeh
 */
public class EventHolder implements Event {

    String playerMessage;
    PlayerListener playerListener;

    public EventHolder(String playerMessage, PlayerListener playerListener) {
        this.playerMessage = playerMessage;
        this.playerListener = playerListener;
    }

    @Override
    public String getPlayerMessage() {
        return playerMessage;
    }

    @Override
    public PlayerListener getEventSender() {
        return playerListener;
    }
}
