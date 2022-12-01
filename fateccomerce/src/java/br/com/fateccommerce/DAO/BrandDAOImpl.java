package br.com.fateccommerce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.fateccommerce.model.Brand;
import br.com.fateccommerce.util.ConnectionFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandDAOImpl implements GenericDAO {

    private Connection conn;

    public BrandDAOImpl() {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de Dados! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public Boolean save(Object object) {

        Brand oBrand = (Brand) object;
        PreparedStatement stmt = null;
        String sql = "insert into brand(name_brand, description_brand) values (?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oBrand.getNameBrand());
            stmt.setString(2, oBrand.getDescriptionBrand());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Brand! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão. Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Object> findAll() {
        List<Object> brands = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT b. * FROM brand b ORDER BY b.name_brand;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Brand brand = new Brand();
                brand.setIdBrand(rs.getInt("id_brand"));
                brand.setNameBrand(rs.getString("name_brand"));
                brand.setDescriptionBrand(rs.getString("description_brand"));
                brands.add(brand);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao Listar Brand! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return brands;
    }

    @Override
    public void deleteById(Integer idObject) {

        String sql = "DELETE FROM brand WHERE id_brand = ?;";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Problemas ao deletar Brand! Erro: " + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão. Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }

    @Override
    public Object findById(Integer idObject) {
        Brand oBrand = new Brand();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM brand WHERE id_brand = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oBrand.setIdBrand(rs.getInt("id_brand"));
                oBrand.setNameBrand(rs.getString("name_brand"));
                oBrand.setDescriptionBrand(rs.getString("description_brand"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao Listar Brand! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return oBrand;
    }

    @Override
    public Boolean update(Object object) {
        Brand oBrand = (Brand) object;
        String sql = "UPDATE brand SET name_brand = ?, description_brand = ? WHERE id_brand = ?;";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oBrand.getNameBrand());
            stmt.setString(2, oBrand.getDescriptionBrand());
            stmt.setInt(3, oBrand.getIdBrand());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Brand! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão. Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }
}
