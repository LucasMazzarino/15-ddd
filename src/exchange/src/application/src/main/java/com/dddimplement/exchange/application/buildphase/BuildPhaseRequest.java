package com.dddimplement.exchange.application.buildphase;

import com.buildingblocks.shared.application.Request;

public class BuildPhaseRequest extends Request {
    private String playerId;
    private boolean buildCity;
    private boolean buildPath;
    private boolean buildSettlement;
    private String territoryType;

    public BuildPhaseRequest(String playerId, boolean buildCity, boolean buildPath, boolean buildSettlement, String territoryType) {
        super(null);
        this.playerId = playerId;
        this.buildCity = buildCity;
        this.buildPath = buildPath;
        this.buildSettlement = buildSettlement;
        this.territoryType = territoryType;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public boolean isBuildCity() {
        return buildCity;
    }

    public void setBuildCity(boolean buildCity) {
        this.buildCity = buildCity;
    }

    public boolean isBuildPath() {
        return buildPath;
    }

    public void setBuildPath(boolean buildPath) {
        this.buildPath = buildPath;
    }

    public boolean isBuildSettlement() {
        return buildSettlement;
    }

    public void setBuildSettlement(boolean buildSettlement) {
        this.buildSettlement = buildSettlement;
    }

    public String getTerritoryType() {
        return territoryType;
    }

    public void setTerritoryType(String territoryType) {
        this.territoryType = territoryType;
    }
}