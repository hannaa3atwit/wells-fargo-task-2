package com.example.<YOUR_PACKAGE>.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;

    @Column
    private String riskProfile;

    @Column
    private String notes;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioSecurity> securities;

    public Portfolio(Long portfolioId, Client client, String riskProfile, String notes, List<PortfolioSecurity> securities) {
        this.portfolioId = portfolioId;
        this.client = client;
        this.riskProfile = riskProfile;
        this.notes = notes;
        this.securities = securities;
    }

    public Portfolio() {}

    public Long getPortfolioId() { return portfolioId; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public String getRiskProfile() { return riskProfile; }
    public void setRiskProfile(String riskProfile) { this.riskProfile = riskProfile; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public List<PortfolioSecurity> getSecurities() { return securities; }
    public void setSecurities(List<PortfolioSecurity> securities) { this.securities = securities; }
}
