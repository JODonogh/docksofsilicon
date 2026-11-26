package com.docksofsilicon.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "headquarters_country", length = 2)
    private String headquartersCountry;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    private CompanyStage stage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    private Honesty honesty;

    @Enumerated(EnumType.STRING)
    @Column(name = "solvency_state", nullable = false, length = 32)
    private SolvencyState solvencyState;

    @Column(precision = 19, scale = 2)
    private BigDecimal cash;

    @Column(precision = 19, scale = 2)
    private BigDecimal debt;

    @Column(name = "credit_limit", precision = 19, scale = 2)
    private BigDecimal creditLimit;

    @Column(precision = 19, scale = 2)
    private BigDecimal sales;

    @Column(name = "pre_tax_profit", precision = 19, scale = 2)
    private BigDecimal preTaxProfit;

    private Integer headcount;

    @Column(name = "customer_count")
    private Long customerCount;

    @Column(name = "hours_per_unit", precision = 12, scale = 4)
    private BigDecimal hoursPerUnit;

    @Column(name = "loyalty_to_location", precision = 8, scale = 4)
    private BigDecimal loyaltyToLocation;

    @Column(name = "allocated_power_mw", precision = 14, scale = 4)
    private BigDecimal allocatedPowerMw;

    @Column(name = "allocated_fiber_gbps", precision = 14, scale = 4)
    private BigDecimal allocatedFiberGbps;

    @Column(name = "api_rate_limit")
    private Long apiRateLimit;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanyLocation> locations = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanyProduct> products = new ArrayList<>();
}
