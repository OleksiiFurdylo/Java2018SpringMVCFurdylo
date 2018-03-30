package com.flowergarden.DAO;

import com.flowergarden.flowers.BouquetWrapper;

/**
 * Created by OleksiiF on 30.03.2018.
 */
public interface BouquetJSONDAO {
    void saveBouquetToFile(BouquetWrapper bouquetWrapper);
    BouquetWrapper readBouquetFromFile(int bouquetId);
}
