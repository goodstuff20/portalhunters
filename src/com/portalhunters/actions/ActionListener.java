package com.portalhunters.actions;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum EventType {
    ENTITY_DEATH_EVENT;
}

public class ActionListener implements Listener {

    Map<EventType, List<Action>> observerList = new HashMap<>();

    public ActionListener(){
        observerList.put(EventType.ENTITY_DEATH_EVENT, new ArrayList<>());
    }

    public void addObserver(Action action, EventType eventType) {
        observerList.get(eventType).add(action);
    }

    public void removeObserver(Action action) {
        for(EventType eventType : observerList.keySet()) {
            if(observerList.get(eventType).contains(action)) {
                observerList.get(eventType).remove(action);
            }
        }
    }

    private void notifyActions(EventType eventType) {
        for(Action action : observerList.get(eventType)) {
            action.observerNotify(eventType);
        }
    }

    @EventHandler
    public void onPlayerDie(EntityDeathEvent event) {
        notifyActions(EventType.ENTITY_DEATH_EVENT);
    }
}
