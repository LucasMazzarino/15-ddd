package com.dddimplement.exchange.domain.player;

import com.dddimplement.exchange.domain.player.entities.Offer;
import com.dddimplement.exchange.domain.player.entities.Territory;
import com.dddimplement.exchange.domain.player.entities.Turn;
import com.dddimplement.exchange.domain.player.events.*;
import com.dddimplement.exchange.domain.player.values.*;
import com.dddimplement.shared.domain.generic.AggregateRoot;

import java.util.List;
import java.util.Optional;

public class Player extends AggregateRoot<PlayerId> {
    private Name name;
    private Color color;
    private Offer offer;
    private Territory territory;
    private List<Offer> resources;
    private Turn turn;

    // region Constructors
    private  Player(PlayerId identity, Name name, Color color, Offer offer, Territory territories, List<Offer> resources, Turn turn) {
        super(identity);
        this.name = name;
        this.color = color;
        this.offer = offer;
        this.territory = territories;
        this.resources = resources;
        this.turn = turn;
    }

    public Player(Name name, Color color,Offer offer, Territory territories, List<Offer> resources, Turn turn) {
        super(new PlayerId());
        this.name = name;
        this.color = color;
        this.offer = offer;
        this.territory = territories;
        this.resources = resources;
        this.turn = turn;
    }
    // endregion

    // region Getter and Setter
    public Name getName() {
        return name;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }

    public List<Offer> getResources() {
        return resources;
    }

    public void setResources(List<Offer> resources) {
        this.resources = resources;
    }

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }
    // endregion

    // region Doman Actions
    public void createdOffer(Integer amount, String type) {
        apply(new OfferCreated(amount, type));
    }

    public void aceptedOffer(String id) {
        apply(new OfferAccepted(id));
    }

    public void rejectedOffer(String id) {
        apply(new OfferRejected(id));
    }

    public void createdCounterOffer(Integer amount, String type) {
        apply(new CounterOfferCreated( amount, type));
    }

    public void createdTerritory(String typeTerritory ) {
        apply(new TerritoryCreated(typeTerritory));
    }

    public void expandedTerriorty(String typeTerritory) {
        apply(new TerritoryExpanded(typeTerritory));
    }

    public void improvedTerritory(String typeTerritory) {
        apply(new TerritoryImproved(typeTerritory));
    }

    public void startedTurn(TurnFaseEnum turnFase) {
        apply(new TurnStarted(turnFase));
    }

    public void endedTurn(TurnFaseEnum turnFase) {
        apply(new TurnEnded(turnFase));
    }
    // endregion

    // region public methods
    public void addTerritory(TerritoryTypeEnum type) {
        if (type == TerritoryTypeEnum.PATH) {
            territory.expand();
        }else if (type == TerritoryTypeEnum.SETTLEMENT) {
            territory.build();
        }
    }

    public void upgradeTerritory(TerritoryTypeEnum type) {
        if (type == TerritoryTypeEnum.CITY) {
            territory.upgrade();
        }
    }

    public void startTurn(){
        this.turn.setFase(TurnFase.of(TurnFaseEnum.ROLL));
        apply(new TurnStarted(TurnFaseEnum.ROLL));

        int diceRoll = this.turn.rollDice();
        System.out.println("Rolled: " + diceRoll);


        this.turn.setFase(TurnFase.of(TurnFaseEnum.TRADE));
        this.turn.setFase(TurnFase.of(TurnFaseEnum.BUILD));

        this.turn.setFase(TurnFase.of(TurnFaseEnum.END));
        apply(new TurnEnded(TurnFaseEnum.END));
    }

    public void makeOffer(Integer amount, String type) {
        createdOffer(amount, type);
    }

    public void acceptOffer(Offer offer) {
        offer.accept();
    }

    public void rejectOffer(Offer offer) {
        offer.reject();
    }

    public void makeCounterOffer(Integer amount, String type) {
        createdCounterOffer( amount, type);
        offer.counterOffer();
    }
    // endregion
}
