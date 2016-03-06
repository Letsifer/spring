/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.altstu.repo;

import edu.altstu.core.Shell;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Евгений
 */
public interface ShellRepository extends JpaRepository<Shell, Long>{
    
}
