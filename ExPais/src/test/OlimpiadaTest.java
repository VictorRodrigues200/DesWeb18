package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Olimpiada;
import service.OlimpiadaService;

public class OlimpiadaTest {
	Olimpiada olimpiada, copia;
	OlimpiadaService olimpiadaService;
	static int ano = 0;

	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		olimpiada = new Olimpiada();
		olimpiada.setAno(ano);
		olimpiada.setTipo("I");
		copia = new Olimpiada();
		copia.setAno(ano);
		copia.setTipo("C");
		olimpiadaService = new OlimpiadaService();
		System.out.println(olimpiada);
		System.out.println(copia);
		System.out.println(ano);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Olimpiada fixture = new Olimpiada();
		fixture.setAno(1);
		fixture.setTipo("I");
		OlimpiadaService novoService = new OlimpiadaService();
		Olimpiada novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		ano = olimpiadaService.criar(olimpiada);
		System.out.println(ano);
		copia.setAno(ano);
		assertEquals("testa criacao", olimpiada, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		olimpiada.setTipo("V");
		olimpiadaService.atualizar(olimpiada);
		olimpiada = olimpiadaService.carregar(olimpiada.getAno());
		assertEquals("testa atualizacao", olimpiada, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setAno(-1);
		copia.setTipo(null);
		olimpiadaService.excluir(ano);
		olimpiada = olimpiadaService.carregar(ano);
		assertEquals("testa exclusao", olimpiada, copia);
	}
}
