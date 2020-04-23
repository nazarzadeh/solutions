package com.stockminer.game;

import com.stockminer.game.api.PlayerListener;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Player implements PlayerListener {
    /**
     * The message counter
     * push into message bus.
     * dispatch message to all listeners
     */
    private String playerName;
    private EventServer eventServer;
    private AtomicInteger receiveCount = new AtomicInteger();
    private AtomicInteger sendCount = new AtomicInteger();
    private Integer totalAvailableMessages;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public Player(String playerName, EventServer eventServer, Integer totalAvailableMessages) {
        this.playerName = playerName;
        this.eventServer = eventServer;
        this.totalAvailableMessages = totalAvailableMessages;
        eventServer.addListener(this);
    }

    @Override
    public void onPlayerReceivedMessage(String receivedMessage) {

        receiveCount.addAndGet(1);
        System.out.println(String.format("player: %s with thread id: %d and thread name: %s received a message: %s"
                ,playerName
                , Thread.currentThread().getId()
                , Thread.currentThread().getName()
                , receivedMessage));

        sendEvent(receivedMessage);
    }

    public void sendEvent(String msg){
        sendCount.addAndGet(1);
        if(sendCount.get() >= totalAvailableMessages && receiveCount.get() >= totalAvailableMessages){
            eventServer.removeListener(this);
        }
        System.out.println(String.format("player: %s with thread id: %d and thread name: %s send a message: %s"
                ,playerName
                , Thread.currentThread().getId()
                , Thread.currentThread().getName()
                , msg));
        eventServer.pushEvent(new EventHolder(msg + "," + sendCount.get(), this));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerName.equals(player.playerName) &&
                eventServer.equals(player.eventServer) &&
                receiveCount.equals(player.receiveCount) &&
                sendCount.equals(player.sendCount) &&
                totalAvailableMessages.equals(player.totalAvailableMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, eventServer, receiveCount, sendCount, totalAvailableMessages);
    }
}
