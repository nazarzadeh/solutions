package com.stockminer.game;

import com.stockminer.game.api.Event;
import com.stockminer.game.api.PlayerListener;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;
/**
 * @author Amir Nazarzadeh
 */
public class EventServer {

    /**
     * The Executor concept allows the task to be executed by a worker thread from the thread pool, while Thread
     * itself execute the task.
     */
    private final ExecutorService executorService;
    /**
     * Subscriber container.
     */
    private HashSet<PlayerListener> eventServerListeners = new HashSet<PlayerListener>();

    /**
     *
     * @param executorService executor thread pool.
     */
    public EventServer(ExecutorService executorService) {
        this.executorService = executorService;
    }
    /**
     *
     * @param listener New listener to be added to subscribers set.
     */
    void addListener(PlayerListener listener){
        eventServerListeners.add(listener);
    }

    /**
     *
     * @param listener Listener pointer to be removed from subscribers set.
     */
    void removeListener(PlayerListener listener){
        eventServerListeners.removeIf(playerListener -> playerListener.equals(listener));
    }

    /**
     *
     * @return Current amount of subscribers.
     */
    public Integer getListenersCount(){
        return eventServerListeners.size();
    }

    /**
     * Creates a new set without the event generator.
     * @param event Event to broadcast.
     */
    void pushEvent(Event event){
        HashSet<PlayerListener> listenersToDispatch = eventServerListeners.stream()
                .filter(esl -> !esl.equals(event.getEventSender()))
                .collect(Collectors.toCollection(HashSet::new));

        dispatcher(listenersToDispatch,event);
    }

    /**
     *
     * @param listenersToDispatch Set of subscribers for dispatch.
     * @param event Event to be dispatched.
     */
    void dispatcher(HashSet<PlayerListener> listenersToDispatch, Event event){
        listenersToDispatch.forEach(listener -> broadcast(listener,event));
    }

    /**
     *
     * @param listener
     * @param event
     */
    private void broadcast(PlayerListener listener, Event event) {
        executorService.execute(() -> listener.onPlayerReceivedMessage(event.getPlayerMessage()));
    }
}
