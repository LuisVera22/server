package com.salonperu.server.services;

import com.salonperu.server.models.Region;
import com.salonperu.server.repositories.IRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    private IRegionRepository repoRegion;

    public List<Region> getAllRegiones() {
        return repoRegion.findAll();
    }
}
