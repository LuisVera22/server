package com.salonperu.server.services;

import com.salonperu.server.models.ImagenSalon;
import com.salonperu.server.repositories.IImagenSalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenSalonService {
    @Autowired
    private IImagenSalonRepository repoImagenSalon;

    private List<ImagenSalon> getImagenesBySalonId(int salonId) {
        return null;
    }
}
