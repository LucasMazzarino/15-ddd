package com.dddimplement.exchange.domain.player.events;

import com.dddimplement.shared.domain.generic.DomainEvent;

public class TerritoryImproved extends DomainEvent {

    private final String territoryId;

    public TerritoryImproved( String territoryId) {
        super(EventsEnum.TERRITORY_IMPROVED.name());
        this.territoryId = territoryId;
    }

    public String getTerritoryId() {
        return territoryId;
    }
}
