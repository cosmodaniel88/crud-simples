package com.books.crud.booksdCrud.compra;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    Page<Compra> findByClienteId(Long clienteId, Pageable pageable);
}
