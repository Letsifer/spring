/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.altstu.core;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "sweet")
@EqualsAndHashCode(callSuper = false)
public class Sweet implements Serializable{
    
    @Id
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @JoinColumn(name = "filling_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Filling filling;
    
    @JoinColumn(name = "shell_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Shell shell;
}
