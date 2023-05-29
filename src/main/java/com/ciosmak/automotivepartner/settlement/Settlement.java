package com.ciosmak.automotivepartner.settlement;

import com.ciosmak.automotivepartner.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "settlements")
public class Settlement extends AbstractEntity
{
    @ToString.Include
    @Column(name = "month_and_year", columnDefinition = "DATE", nullable = false)
    private Date monthAndYear;

    @Column(name = "net_profit", scale = 2, nullable = false)
    private BigDecimal netProfit;

    @Column(name = "factor", scale = 2, nullable = false)
    private BigDecimal factor;

    @Column(name = "tips", scale = 2, nullable = false)
    private BigDecimal tips;

    @Column(name = "penalties", scale = 2, nullable = false)
    private BigDecimal penalties;

    @ToString.Include
    @Column(name = "final_profit", scale = 2, nullable = false)
    private BigDecimal finalProfit;

    @Column(name = "bug_reported", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean bugReported;
}
