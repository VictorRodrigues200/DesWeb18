package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Modalidade;
import service.ModalidadeService;

public class ModalidadeTest {
	Modalidade modalidade, copia;
	ModalidadeService modalidadeService;
	static int id = 0;

		@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		modalidade = new Modalidade();
		modalidade.setId(id);
		modalidade.setNome("Judô");
		modalidade.setOuro(8);
		modalidade.setPrata(6);
		modalidade.setBronze(1);
		copia = new Modalidade();
		copia.setId(id);
		copia.setNome("Judô");
		copia.setOuro(8);
		copia.setPrata(6);
		copia.setBronze(1);
		modalidadeService = new ModalidadeService();
		System.out.println(modalidade);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
	
		Modalidade fixture = new Modalidade();
		fixture.setId(1);
		fixture.setNome("Judô");
		fixture.setOuro(8);
		fixture.setPrata(6);
		fixture.setBronze(1);
		ModalidadeService novoService = new ModalidadeService();
		Modalidade novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = modalidadeService.criar(modalidade);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", modalidade, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		modalidade.setNome("Judô");
		modalidade.setOuro(8);
		modalidade.setPrata(6);	
		modalidade.setBronze(1);
		modalidadeService.atualizar(modalidade);
		modalidade = modalidadeService.carregar(modalidade.getId());
		assertEquals("testa atualizacao", modalidade, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setOuro(0);
		copia.setPrata(0);
		copia.setBronze(0);
		modalidadeService.excluir(id);
		modalidade = modalidadeService.carregar(id);
		assertEquals("testa exclusao", modalidade, copia);
	}
}
