package com.flowergarden.flowers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by OleksiiF on 30.03.2018.
 */
@Repository
@XmlRootElement(name = "bouquet")
@XmlAccessorType(XmlAccessType.FIELD)
public class BouquetWrapper {

    private int id;
    private String name;
    private float assemblyPrice;

    @XmlElement(name = "flowers")
    private List<FlowerWrapper> flowerWrappers;

    BouquetWrapper bouquetWrapper;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAssemblyPrice() {
        return assemblyPrice;
    }

    public void setAssemblyPrice(float assemblyPrice) {
        this.assemblyPrice = assemblyPrice;
    }

    public List<FlowerWrapper> getFlowerWrappers() {
        return flowerWrappers;
    }

    public void setFlowerWrappers(List<FlowerWrapper> flowerWrappers) {
        this.flowerWrappers = flowerWrappers;
    }
}
