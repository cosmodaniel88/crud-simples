package com.books.crud.booksdCrud.compra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findByClienteId(Long clienteId);
}
