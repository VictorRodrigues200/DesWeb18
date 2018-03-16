package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Olimpiada;

public class OlimpiadaDAO {

	public int criar(Olimpiada olimpiada) {
		String sqlInsert = "INSERT INTO OLIMPIADA(ANO,TIPO) VALUES (?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, olimpiada.getAno());
			stm.setString(2, olimpiada.getTipo());
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					olimpiada.setAno(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return olimpiada.getAno();
	}
	
	public void atualizar(Olimpiada olimpiada) {
		String sqlUpdate = "UPDATE OLIMPIADA SET ANO =?, TIPO =?  WHERE ANO=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, olimpiada.getAno());
			stm.setString(2,olimpiada.getTipo());
			stm.setInt(3, olimpiada.getAno());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int ano) {
		String sqlDelete = "DELETE FROM OLIMPIADA WHERE ANO = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1,ano);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Olimpiada carregar(int ano) {
		Olimpiada olimpiada = new Olimpiada();
		String sqlSelect = "SELECT TIPO FROM OLIMPIADA WHERE OLIMPIADA.ANO = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, ano);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					olimpiada.setTipo(rs.getString("TIPO"));
				} else {
					olimpiada.setAno(-1);
					olimpiada.setTipo(null);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return olimpiada;
	}

}
