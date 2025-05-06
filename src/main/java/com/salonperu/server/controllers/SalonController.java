package com.salonperu.server.controllers;

import com.salonperu.server.models.ImagenSalon;
import com.salonperu.server.models.Salon;
import com.salonperu.server.models.dto.SalonDTO;
import com.salonperu.server.services.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/salones")
@CrossOrigin(origins = "http://localhost:4200")
public class SalonController {
    @Autowired
    private SalonService salonService;

    @GetMapping
    public ResponseEntity<List<SalonDTO>> getSalones() throws IOException {
        List<SalonDTO> salones = salonService.obtenerSalones();

        if (salones.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            for (SalonDTO salon : salones) {
                // Procesar cada imagen de la lista (se asume que son URLs relativas tipo /img/xxx.jpg)
                List<String> imagenesProcesadas = new ArrayList<>();
                for (Object img : salon.imagenes) {
                    String ruta = (String) img;
                    if (ruta != null && !ruta.isEmpty()) {
                        try {
                            byte[] imageBytes = Files.readAllBytes(Paths.get("src/main/resources/static" + ruta));
                            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                            imagenesProcesadas.add("data:image/jpeg;base64," + base64Image);
                        } catch (IOException e) {
                            // Si hay error leyendo una imagen, puedes ignorarla o registrar el error
                            imagenesProcesadas.add(""); // O no agregarla si prefieres
                        }
                    }
                }
                salon.imagenes = imagenesProcesadas;
            }

            return ResponseEntity.ok(salones);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalonDTO> getSalonById(@PathVariable Integer id) throws IOException {
        SalonDTO salon = salonService.obtenerSalonPorId(id);

        // Si no se encuentra el salón, devolvemos un código 404 (No encontrado)
        if (salon == null) {
            return ResponseEntity.notFound().build();
        }

        // Procesar las imágenes de la misma manera que en el listado
        List<String> imagenesProcesadas = new ArrayList<>();
        for (Object img : salon.imagenes) {
            String ruta = (String) img;
            if (ruta != null && !ruta.isEmpty()) {
                try {
                    byte[] imageBytes = Files.readAllBytes(Paths.get("src/main/resources/static" + ruta));
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    imagenesProcesadas.add("data:image/jpeg;base64," + base64Image);
                } catch (IOException e) {
                    // Si hay error leyendo una imagen, puedes ignorarla o registrar el error
                    imagenesProcesadas.add("");
                }
            }
        }
        salon.imagenes = imagenesProcesadas;

        return ResponseEntity.ok(salon);
    }

    @PostMapping
    public ResponseEntity<Salon> createSalon(@RequestBody Salon salon) {
        try {
            // Procesar imágenes
            for (ImagenSalon imagen : salon.getImagenes()) {
                if (imagen.getUrlImagen() != null) {
                    byte[] imageBytes = Base64.getDecoder().decode(imagen.getUrlImagen().split(",")[1]);
                    String filePath = saveImage(imageBytes);
                    imagen.setUrlImagen(filePath);
                    imagen.setSalon(salon); // Establecer la relación bidireccional
                }
            }

            Salon nuevo = salonService.saveSalon(salon);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (Exception e) {
            System.out.println("no se pudo guardar" + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSalon(@PathVariable int id, @RequestBody Salon actualizando) {
        Salon anterior = salonService.getSalonById(id);
        if (anterior == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el salon");
        }

        anterior.setNombre(actualizando.getNombre());
        anterior.setDescripcion(actualizando.getDescripcion());
        anterior.setCapacidad(actualizando.getCapacidad());
        anterior.setDireccion(actualizando.getDireccion());
        anterior.setDireccion(actualizando.getDireccion());
        anterior.setRegion(actualizando.getRegion());
        anterior.setPrecioBase(actualizando.getPrecioBase());
        anterior.setCaracteristicas(actualizando.getCaracteristicas());
        anterior.setTiposEvento(actualizando.getTiposEvento());

        try {
            Salon cambiado = salonService.updateSalon(anterior);
            return ResponseEntity.status(HttpStatus.OK).body(cambiado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el salon");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSalon(@PathVariable int id) {
        Salon salon = salonService.getSalonById(id);
        if (salon == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el salon");
        }
        try {
            salonService.deleteSalon(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Salon eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el salon");
        }
    }


    private String saveImage(byte[] imageBytes) {
        // Definir el path para la carpeta static en recursos
        String folderPath = "src/main/resources/static/images/"; // Carpeta dentro de "static"

        // Crear un nombre único para la imagen (UUID)
        String fileName = UUID.randomUUID().toString() + ".jpg";

        // Crear la ruta completa para guardar la imagen
        Path path = Paths.get(folderPath + fileName);

        try {
            // Escribir el archivo
            Files.createDirectories(path.getParent());  // Asegurarse de que el directorio exista
            Files.write(path, imageBytes);  // Guardar el archivo
            return "/images/" + fileName;  // Retorna la URL para acceder a la imagen (servida como recurso estático)
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar la imagen", e);
        }
    }
}
