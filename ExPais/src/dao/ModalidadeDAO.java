package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Modalidade;

public class ModalidadeDAO {

	public int criar(Modalidade modalidade) {
		String sqlInsert = "INSERT INTO MODALIDADE(NOME, OURO, PRATA, BRONZE) VALUES (?,?,?,?)";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, modalidade.getNome());
			stm.setInt(2, modalidade.getOuro());
			stm.setInt(3, modalidade.getPrata());
			stm.setInt(4, modalidade.getBronze());
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					modalidade.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modalidade.getId();
	}
	
	public void atualizar(Modalidade modalidade) {
		String sqlUpdate = "UPDATE MODALIDADE SET NOME =?, OURO =?, PRATA =?, BRONZE =?  WHERE ID=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1,modalidade.getNome());
			stm.setInt(2, modalidade.getOuro());
			stm.setInt(3, modalidade.getPrata());
			stm.setInt(4, modalidade.getBronze());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM MODALIDADE WHERE ID = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Modalidade carregar(int id) {
		Modalidade modalidade = new Modalidade();
		modalidade.setId(id);
		String sqlSelect = "SELECT TIPO FROM MODALIDADE WHERE OLIMPIADA.ID = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1,id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					modalidade.setNome(rs.getString("NOME"));
					modalidade.setOuro(rs.getInt("OURO"));
					modalidade.setPrata(rs.getInt("PRATA"));
					modalidade.setBronze(rs.getInt("BRONZE"));
				} else {
					modalidade.setId(-1);
					modalidade.setNome(null);
					modalidade.setOuro(-1);
					modalidade.setPrata(-1);
					modalidade.setBronze(-1);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return modalidade;
	}
}
