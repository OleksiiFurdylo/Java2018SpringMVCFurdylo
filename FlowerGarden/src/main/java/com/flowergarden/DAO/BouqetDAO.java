package com.flowergarden.DAO;

import java.sql.SQLException;

/**
 * Created by OleksiiF on 13.03.2018.
 */
public interface BouqetDAO {
    float getAssemblePriceForBouqet (int bouqetId);
    void closeConnection();
}
