package com.dddimplement.exchange.domain.trade;

import com.dddimplement.exchange.domain.player.entities.Offer;
import com.dddimplement.exchange.domain.trade.entities.Domestic;
import com.dddimplement.exchange.domain.trade.entities.Maritime;
import com.dddimplement.exchange.domain.trade.events.ExchangeRateImproved;
import com.dddimplement.exchange.domain.trade.events.NewOfferReceived;
import com.dddimplement.exchange.domain.trade.events.TradeSelected;
import com.dddimplement.exchange.domain.trade.values.*;
import com.dddimplement.shared.domain.generic.AggregateRoot;

public class Trade extends AggregateRoot<TradeId> {
    private TradeState state;
    private Domestic domestic;
    private Maritime maritime;

    //region Constructors

    private Trade( TradeId identity, TradeState state, Domestic domestic, Maritime maritime ) {
        super(identity);
        this.state = state;
        this.domestic = domestic;
        this.maritime = maritime;
    }

    public Trade(TradeState state, Domestic domestic, Maritime maritime) {
        super(new TradeId());
        this.state = state;
        this.domestic = domestic;
        this.maritime = maritime;
    }

    //endregion

    //domain events
    public void tradeSelected(TradeType type) {
        apply(new TradeSelected(type));
    }

    public void exchangeRateImproved(Integer newRate) {
        apply(new ExchangeRateImproved(newRate));
    }

    public void newOfferReceived(String offerId, Integer newRate) {
        apply(new NewOfferReceived(offerId, newRate));
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
    public void selectTrade(TradeType tradeType) {
        switch (tradeType) {
            case MARITIME -> tradeSelected(TradeType.MARITIME);
            case DOMESTIC ->tradeSelected(TradeType.DOMESTIC);
            default -> throw new IllegalArgumentException("Invalid trade type");
        }
    }

    public void improveExchangeRate() {
        ExchangeRate currentRate = maritime.getExchangeRate();
        Value newValueOrdered = Value.of(currentRate.getValueOrdered().getValue() - 1);
        maritime.improveRate(newValueOrdered);
        exchangeRateImproved(newValueOrdered.getValue());
    }

    public void improveDomesticExchangeRate(Offer offer) {
        ExchangeRate currentRate = domestic.getExchangeRate();
        Value newValueOrdered = Value.of(currentRate.getValueOrdered().getValue() - 1);
        domestic.improveRate(newValueOrdered);
    }
    //endregion
}
