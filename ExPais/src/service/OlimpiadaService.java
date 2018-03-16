package service;

import dao.OlimpiadaDAO;
import model.Olimpiada;

public class OlimpiadaService {

		OlimpiadaDAO dao = new OlimpiadaDAO();
		
		public int criar(Olimpiada olimpiada) {
			return dao.criar(olimpiada);
		}
		
		public void atualizar(Olimpiada olimpiada){
			dao.atualizar(olimpiada);
		}
		
		public void excluir(int ano){
			dao.excluir(ano);
		}
		
		public Olimpiada carregar(int ano){
			return dao.carregar(ano);
		}

}