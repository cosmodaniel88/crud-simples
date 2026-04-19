package com.books.crud.booksdCrud;

import com.books.crud.booksdCrud.cliente.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BooksdCrudApplicationTests {

	@InjectMocks
	private ClienteService clienteService;

	@Mock
	private ClienteRepository clienteRepository;

	@Mock
	private ClienteMapper clienteMapper;

	@Test
	void deveCadastrarCliente() {

		ClienteCriarDTO dto = new ClienteCriarDTO(
				"000.000.000-00",
				"",
				"MarquinhosTester",
		LocalDate.of(2000,01,1
		));

		Cliente cliente = new Cliente();

		when(clienteMapper.paraEntidade(dto)).thenReturn(cliente);

		clienteService.cadastrarNovoCliente(dto);

		verify(clienteRepository).save(cliente);


	}
}
