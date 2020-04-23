package com.stockminer;

import com.stockminer.game.EventServer;
import com.stockminer.game.Player;
import java.util.concurrent.Executors;

/**
 * @author Amir Nazarzadeh
 */
public class ChatGame {
    private static final Integer TOTAL_AVAILABLE_MESSAGES = 10;

    public static void main(String[] args) {
        wait(start(args));
    }

    /**
     * The main thread is up and running until
     * the moment that there is no subscriber in {@code EventServer}.
     *
     * @param eventServer
     */
    private static void wait(EventServer eventServer) {
        for (; ; ) {
            if (eventServer.getListenersCount().equals(0)) {
                System.out.println("Finalized");
                Runtime.getRuntime().exit(0);
            }
            try {
                Thread.sleep(30L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param args The args[1] is the number of active thread.
     *             The args[0] is the initial message.
     * @return a {@code EventServer} to manage raised events.
     */
    private static EventServer start(String[] args) {
        EventServer eventServer;
        int numberOfThreads;
        try {
            numberOfThreads = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println(String.format("Wrong input for thread pool, Entered : %s " +
                    "thread pool would be set to one", args[1]));
            numberOfThreads = 1;
        }
        String startMessage = args[0];
        try {
            eventServer = new EventServer(Executors.newFixedThreadPool(numberOfThreads));
        }catch (IllegalArgumentException e){
            eventServer = new EventServer(Executors.newFixedThreadPool(1));
        }

        Player player1 = new Player("player_1", eventServer, TOTAL_AVAILABLE_MESSAGES);
        Player player2 = new Player("player_2", eventServer, TOTAL_AVAILABLE_MESSAGES);
        player1.sendEvent(startMessage);
        return eventServer;
    }
}
