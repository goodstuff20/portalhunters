package com.portalhunters.actions;

import com.portalhunters.PortalHunters;
import com.portalhunters.User;

public class Action {

    //public enum ActionType {PASSIVE, ACTIVE};
    //private ActionType actionType;
    private boolean hasListenerObserver; //most passive skills don't need an observer
    private boolean hasRunnable;
    private User user;
    //TODO strength or so?

    public Action(boolean hasListenerObserver, boolean hasRunnable) {
        this.hasListenerObserver = hasListenerObserver;
        this.hasRunnable = hasRunnable;
        if(hasListenerObserver){
            observerInit();
        }
    }

    private void observerInit(){
        // e.g. PortalHunters.instance.actionListener.addObserver(this, EventType.ENTITY_DEATH_EVENT);
    }

    public void observerNotify(EventType eventType){
        //override and fit to specific action, includes triggers like rightClick weapon type...
        // only if allowed, i.e. if one-timer action
        // if a one-timer do ...removeObserver(this, eventType); if(user != null && hasRunnable) user.removeAction(this);
    }

    public void actionRunnable(User user) {
        //override and fit to specific action, if hasRunnable
    }

    public boolean hasListenerObserver() {
        return hasListenerObserver;
    }

    public boolean hasRunnable() {
        return hasRunnable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
