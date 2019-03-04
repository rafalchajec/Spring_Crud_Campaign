package com.crud.springcrudcampaign.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "campaign")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String campaignName;

    @NotNull
    private String keyword;

    @NotNull
    private Long bidAmount;

    @NotNull
    private Long campaignFund;

    @NotNull
    private String status;

    @NotNull
    private String town;

    @NotNull
    private Long radius;

    public Campaign(@NotNull String campaignName, @NotNull String keyword, @NotNull Long bidAmount, @NotNull Long campaignFund, @NotNull String status, @NotNull String town, @NotNull Long radius) {
        this.campaignName = campaignName;
        this.keyword = keyword;
        this.bidAmount = bidAmount;
        this.campaignFund = campaignFund;
        this.status = status;
        this.town = town;
        this.radius = radius;
    }

    public Campaign() {

    }

    @Override
    public String toString() {
        return "Campaign{" + "Campaign name = " + campaignName +
                ", keyword = " + keyword +
                ", bid amount = " + bidAmount +
                ", campaign fund = " + campaignFund +
                ", status = " + status+
                ", town = " + town +
                ", radius[km] = " + radius + '}';
    }

    public Long getId() {
        return id;
    }

    public Campaign setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public Campaign setCampaignName(String campaignName) {
        this.campaignName = campaignName;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public Campaign setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public Long getBidAmount() {
        return bidAmount;
    }

    public Campaign setBidAmount(Long bidAmount) {
        this.bidAmount = bidAmount;
        return this;
    }

    public Long getCampaignFund() {
        return campaignFund;
    }

    public Campaign setCampaignFund(Long campaignFund) {
        this.campaignFund = campaignFund;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Campaign setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getTown() {
        return town;
    }

    public Campaign setTown(String town) {
        this.town = town;
        return this;
    }

    public Long getRadius() {
        return radius;
    }

    public Campaign setRadius(Long radius) {
        this.radius = radius;
        return this;
    }

    //• Campaign name (mandatory)
    //
    //• Keywords (mandatory, pre-populated with typeahead)
    //
    //• Bid amount (mandatory, min amount )
    //
    //• Campaign fund (mandatory and deducted from their Emerald account funds, new balance updated on screen
    //
    //• Status (on or off - mandatory)
    //
    //• Town (can pick from pre-populated dropdown list of towns)
    //
    //• Radius (mandatory in kilometres)
}
