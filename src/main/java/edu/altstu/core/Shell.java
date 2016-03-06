package edu.altstu.core;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "shell")
@EqualsAndHashCode(callSuper = false)
public class Shell implements Serializable{
    
    @Id
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
}