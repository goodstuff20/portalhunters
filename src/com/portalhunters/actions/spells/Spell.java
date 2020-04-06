package com.portalhunters.actions.spells;

import com.portalhunters.PortalHunters;
import com.portalhunters.actions.Action;
import com.portalhunters.actions.EventType;

public class Spell extends Action {
    public Spell(boolean hasListenerObserver, boolean hasRunnable) {
        super(hasListenerObserver, hasRunnable);
    }

    @Override
    protected void observerInit() {
        //super.observerInit();
        PortalHunters.instance.actionListener.addObserver(this, EventType.ENTITY_DEATH_EVENT);
    }

    @Override
    public void observerNotify(EventType eventType) {
        //super.observerNotify(eventType);
    }
}
