package com.google.buscador.venta.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.buscador.util.ConectaDB;
import com.google.buscador.venta.bean.TecladoBean;
import com.google.buscador.venta.bean.CategoriaBean;

public class MySqlTecladoDAO implements TecladoDAO{

	@Override
	public int insertaTeclado(TecladoBean obj) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		int insertados = -1;
		try {
			String sql = "insert into teclado values(null,?,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre_te());
			pstm.setString(2, obj.getColor_te());
			pstm.setString(3, obj.getForma_te());
			pstm.setInt(4, obj.getCategoria().getIdCategoria());
			
			insertados = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return insertados;
	}

	

	@Override
	public List<CategoriaBean> listaCategoria() throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<CategoriaBean> lista = new ArrayList<CategoriaBean>();
		try {
			String sql = "select * from categoia";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			CategoriaBean bean = null;
			while(rs.next()){
				bean = new CategoriaBean();
				bean.setIdCategoria(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				lista.add(bean);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}
	
	
	
}
