package com.alexmalotky.entity;

import com.alexmalotky.persistence.GenericDao;

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
}
