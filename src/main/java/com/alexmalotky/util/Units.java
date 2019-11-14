package com.alexmalotky.util;

import com.alexmalotky.entity.Volume;
import com.alexmalotky.entity.Weight;
import com.alexmalotky.persistence.GenericDao;

import java.util.Iterator;
import java.util.List;

public class Units {

    private List<Weight> weights;
    private List<Volume> volumes;

    public Units() {
        GenericDao<Volume> volumeDao = new GenericDao<>(Volume.class);
        GenericDao<Weight> weightDao = new GenericDao<>(Weight.class);

        weights = weightDao.getAll();
        volumes = volumeDao.getAll();
    }

    public List<Weight> getWeights() {
        return weights;
    }

    public void setWeights(List<Weight> weights) {
        this.weights = weights;
    }

    public List<Volume> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<Volume> volume) {
        this.volumes = volume;
    }

    public String getJson() {
        String output = "{ ";

        output += "\"Volume\":[";
        for(Iterator it = volumes.iterator(); it.hasNext();) {
            Volume obj = (Volume)it.next();
            output += "{\"name\":\"" + obj.getName() + "\", " +
                    "\"code\":\"" + obj.getCode() + "\", " +
                    "\"value\":" + obj.getValue() + "}";
            if(it.hasNext())
                output += ", ";
        }

        output += "], \"Weight\":[";
        for(Iterator it = weights.iterator(); it.hasNext();) {
            Weight obj = (Weight)it.next();
            output += "{\"name\":\"" + obj.getName() + "\", " +
                    "\"code\":\"" + obj.getCode() + "\", " +
                    "\"value\":" + obj.getValue() + "}";
            if(it.hasNext())
                output += ", ";
        }

        output += " ]}";

        return output;
    }
}
