package com.docksofsilicon.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "company_locations")
@Getter
@Setter
@NoArgsConstructor
public class CompanyLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(name = "region_code", nullable = false, length = 32)
    private String regionCode;

    @Column(name = "is_headquarters", nullable = false)
    private boolean headquarters;

    @Column(name = "local_power_mw")
    private float localPowerMw;

    @Column(name = "local_fiber_gbps")
    private float localFiberGbps;

    @Column(name = "local_loyalty", length = 32)
    private int localLoyalty;
}
