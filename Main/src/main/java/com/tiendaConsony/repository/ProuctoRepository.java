package com.tiendaConsony.repository;

import com.tiendaConsony.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProuctoRepository extends JpaRepository<Productos, Integer> {
}
