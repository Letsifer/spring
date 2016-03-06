package edu.altstu.core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Евгений
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "sweet_pack")
@EqualsAndHashCode(callSuper = false)
public class SweetPack implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name = "barcode", nullable = false)
    private String barcode;
    
    @Column(name = "price")
    private Double price;
    
    @JoinColumn(name = "sweet_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Sweet sweet;
    
    private Integer number;
    
    @Column(name = "packing_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date packingDate;
    
    @Column(name = "expire_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expireDate;
}
