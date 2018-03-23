package com.flowergarden.DAO.impl;

import com.flowergarden.DAO.BouqetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by OleksiiF on 13.03.2018.
 */
@Repository
public class BouquetDAOimpl implements BouqetDAO {

    private Connection conn;

    @Autowired
    public BouquetDAOimpl(DataSource dataSource) {
        try {
            this.conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public float getAssemblePriceForBouqet(int bouqetId) {
        float assemblePrice = 0.0f;

        try {
            PreparedStatement st = conn.prepareStatement("SELECT assemble_price FROM bouquet WHERE bouquet.id = ?");
            st.setInt(1, bouqetId);
            ResultSet rs = st.executeQuery();
            assemblePrice = rs.getFloat("assemble_price");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return assemblePrice;
    }

    @Override
    public void setConnection(Connection conn) {
        this.conn = conn;
    }


}
