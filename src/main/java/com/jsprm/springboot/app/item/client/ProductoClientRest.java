package com.jsprm.springboot.app.item.client;

import com.jsprm.springboot.app.item.entities.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "servicio-productos", url = "localhost:8066")
public interface ProductoClientRest {

    @GetMapping("/listar")
    List<Producto> listar();

    @GetMapping("/ver/{id}")
    Producto detalle(@PathVariable Long id);
}
