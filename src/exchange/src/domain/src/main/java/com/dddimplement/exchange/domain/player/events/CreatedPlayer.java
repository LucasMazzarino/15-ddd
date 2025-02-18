package com.dddimplement.exchange.domain.player.events;

import com.dddimplement.exchange.domain.player.values.Color;
import com.dddimplement.exchange.domain.player.values.Name;
import com.dddimplement.exchange.domain.player.values.ResourceType;
import com.dddimplement.shared.domain.generic.DomainEvent;

import java.util.List;

public class CreatedPlayer extends DomainEvent {
    private final String name;
    private final String color;

    public CreatedPlayer(String name, String color) {
        super(EventsEnum.CREATED_PLAYER.name());
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
