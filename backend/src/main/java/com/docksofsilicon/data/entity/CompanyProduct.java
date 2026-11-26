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
@Table(name = "company_products")
@Getter
@Setter
@NoArgsConstructor
public class CompanyProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_ai", nullable = false)
    private boolean ai;

    @Enumerated(EnumType.STRING)
    @Column(name = "lifecycle_state", nullable = false, length = 32)
    private ProductLifecycleState lifecycleState;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_model", nullable = false, length = 32)
    private PaymentModel paymentModel;

    @Column(name = "value_score", precision = 12, scale = 4)
    private BigDecimal valueScore;

    @Column(name = "unit_cost", precision = 19, scale = 4)
    private BigDecimal unitCost;
}
