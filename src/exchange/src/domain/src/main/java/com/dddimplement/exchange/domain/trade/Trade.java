package com.dddimplement.exchange.domain.trade;

import com.dddimplement.exchange.domain.trade.entities.Domestic;
import com.dddimplement.exchange.domain.trade.entities.Maritime;
import com.dddimplement.exchange.domain.trade.events.*;
import com.dddimplement.exchange.domain.trade.values.*;
import com.dddimplement.shared.domain.generic.AggregateRoot;

public class Trade extends AggregateRoot<TradeId> {
    private TradeState state;
    private Domestic domestic;
    private Maritime maritime;

    //region Constructors

    public Trade(Integer valueOrdered, Integer valueReceived) {
        super(new TradeId());
        subscribe(new TradeHandler(this));
        apply(new TradeCreated(valueOrdered, valueReceived));
    }

    private Trade( TradeId identity ) {
        super(identity);
        subscribe(new TradeHandler(this));
    }

    //endregion

    //domain events
    public void tradeCreated (Integer valueOrdered, Integer valueReceived) {
        apply(new TradeCreated(valueOrdered, valueReceived));
    }

    public void tradeSelected(TradeType type) {
        apply(new TradeSelected(type));
    }

    public void exchangeRateImproved(Integer valueOrdered, Integer valueReceived) {
        apply(new ExchangeRateImproved(valueOrdered, valueReceived));
    }

    public void exchangeRateChanged(Integer valueIOrdered, Integer valueReceived) {
        apply(new ExchangeRateChanged(valueIOrdered, valueReceived));
    }

    //endregion

    //region Getters and Setters

    public TradeState getState() {
        return state;
    }

    public void setState(TradeState state) {
        this.state = state;
    }

    public Domestic getDomestic() {
        return domestic;
    }

    public void setDomestic(Domestic domestic) {
        this.domestic = domestic;
    }

    public Maritime getMaritime() {
        return maritime;
    }

    public void setMaritime(Maritime maritime) {
        this.maritime = maritime;
    }


    //endregion

    //region Methods

    //endregion
}
