package com.jsprm.springboot.app.item.service;

import com.jsprm.springboot.app.item.entities.models.Item;
import com.jsprm.springboot.app.item.entities.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final RestTemplate clienteRest;

    @Autowired
    public ItemServiceImpl(RestTemplate clienteRest) {
        this.clienteRest = clienteRest;
    }

    @Override
    public List<Item> buscarTodos() {
        List<Producto> productos = Arrays.asList(Objects.requireNonNull(clienteRest.getForObject("http://localhost:8066/listar", Producto[].class)));
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item buscarPorId(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Producto producto = clienteRest.getForObject("http://localhost:8066/ver/{id}", Producto.class, pathVariables);
        return new Item(producto, cantidad);
    }
}
