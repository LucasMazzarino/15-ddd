package com.dddimplement.exchange.domain.trade;


import com.dddimplement.exchange.domain.trade.events.*;
import com.dddimplement.exchange.domain.trade.values.TradeType;
import com.dddimplement.shared.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TradeTest {

    private Trade trade;

    @BeforeEach
    void setUp() {
        trade = new Trade(5, 10);
    }

    @Test
    void testTradeCreated() {
        Trade newTrade = new Trade(5, 10);
        newTrade.tradeCreated(5, 10);

        assertNotNull(trade.getDomestic());
        assertNotNull(trade.getMaritime());
        assertEquals(5, trade.getDomestic().getExchangeRate().getValueOrdered().getValue());
        assertEquals(10, trade.getDomestic().getExchangeRate().getValueReceived().getValue());
        assertEquals(5, trade.getMaritime().getExchangeRate().getValueOrdered().getValue());
        assertEquals(10, trade.getMaritime().getExchangeRate().getValueReceived().getValue());
        assertFalse(trade.getState().getState());
    }

    @Test
    void testTradeSelectedMaritime() {
        trade.tradeSelected(TradeType.MARITIME);
        assertTrue(trade.getMaritime().isActive());
        assertFalse(trade.getDomestic().isActive());
    }

    @Test
    void testTradeSelectedDomestic() {
        trade.tradeSelected(TradeType.DOMESTIC);
        assertTrue(trade.getDomestic().isActive());
        assertFalse(trade.getMaritime().isActive());
    }

    @Test
    void testExchangeRateImproved() {
        trade.exchangeRateImproved(2, 3);
        assertEquals(7, trade.getMaritime().getExchangeRate().getValueOrdered().getValue());
        assertEquals(13, trade.getMaritime().getExchangeRate().getValueReceived().getValue());
    }

    @Test
    void testExchangeRateChanged() {
        trade.exchangeRateChanged(3, 4);
        assertEquals(8, trade.getDomestic().getExchangeRate().getValueOrdered().getValue());
        assertEquals(14, trade.getDomestic().getExchangeRate().getValueReceived().getValue());
    }

    @Test
    void testTradeCreatedWithDifferentValues() {
        Trade newTrade = new Trade(7, 14);
        newTrade.tradeCreated(7, 14);

        assertNotNull(newTrade.getDomestic());
        assertNotNull(newTrade.getMaritime());
        assertEquals(7, newTrade.getDomestic().getExchangeRate().getValueOrdered().getValue());
        assertEquals(14, newTrade.getDomestic().getExchangeRate().getValueReceived().getValue());
        assertEquals(7, newTrade.getMaritime().getExchangeRate().getValueOrdered().getValue());
        assertEquals(14, newTrade.getMaritime().getExchangeRate().getValueReceived().getValue());
        assertFalse(newTrade.getState().getState());
    }

    @Test
    void testExchangeRateChangedWithNegativeValues() {
        trade.exchangeRateChanged(-1, -2);

        assertEquals(4, trade.getDomestic().getExchangeRate().getValueOrdered().getValue());
        assertEquals(8, trade.getDomestic().getExchangeRate().getValueReceived().getValue());
    }

    @Test
    void testExchangeRateImprovedWithNegativeValues() {
        trade.exchangeRateImproved(-1, -2);

        assertEquals(4, trade.getMaritime().getExchangeRate().getValueOrdered().getValue());
        assertEquals(8, trade.getMaritime().getExchangeRate().getValueReceived().getValue());
    }

    @Test
    void fromMethod() {
        String identity = "trade-1";
        List<DomainEvent> events = List.of(new TradeCreated(4, 1));

        Trade trade = Trade.from(identity, events);

        assertNotNull(trade);
        assertEquals(identity, trade.getIdentity().getValue());
        assertEquals(4, trade.getDomestic().getExchangeRate().getValueOrdered().getValue());
        assertEquals(1, trade.getDomestic().getExchangeRate().getValueReceived().getValue());

    }


    @Test
    void testTradeSelectedNullType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            trade.tradeSelected(null);
        });

        String expectedMessage = "Trade type cannot be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void fromMethodWithMultipleEvents() {
        String identity = "trade-2";
        List<DomainEvent> events = List.of(
                new TradeCreated(6, 2),
                new TradeSelected(TradeType.MARITIME),
                new ExchangeRateImproved(3, 1)
        );

        Trade trade = Trade.from(identity, events);

        assertNotNull(trade);
        assertEquals(identity, trade.getIdentity().getValue());
        assertTrue(trade.getMaritime().isActive());
        assertFalse(trade.getDomestic().isActive());
        assertEquals(9, trade.getMaritime().getExchangeRate().getValueOrdered().getValue());
        assertEquals(3, trade.getMaritime().getExchangeRate().getValueReceived().getValue());
    }




}