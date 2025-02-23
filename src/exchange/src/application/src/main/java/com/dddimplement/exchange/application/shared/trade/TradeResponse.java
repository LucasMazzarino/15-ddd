package com.dddimplement.exchange.application.shared.trade;

import java.util.List;

public class TradeResponse {
    private final String tradeId;
    private final String state;
    private final ExchangeRate domesticExchangeRate;
    private final ExchangeRate maritimeExchangeRate;

    public TradeResponse(String tradeId, String state, ExchangeRate domesticExchangeRate, ExchangeRate maritimeExchangeRate) {
        this.tradeId = tradeId;
        this.state = state;
        this.domesticExchangeRate = domesticExchangeRate;
        this.maritimeExchangeRate = maritimeExchangeRate;
    }

    public String getTradeId() {
        return tradeId;
    }

    public String getState() {
        return state;
    }

    public ExchangeRate getDomesticExchangeRate() {
        return domesticExchangeRate;
    }

    public ExchangeRate getMaritimeExchangeRate() {
        return maritimeExchangeRate;
    }

    public static class ExchangeRate {
        private final Integer valueOrdered;
        private final Integer valueReceived;

        public ExchangeRate(Integer valueOrdered, Integer valueReceived) {
            this.valueOrdered = valueOrdered;
            this.valueReceived = valueReceived;
        }

        public Integer getValueOrdered() {
            return valueOrdered;
        }

        public Integer getValueReceived() {
            return valueReceived;
        }
    }
}