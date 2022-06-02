package com.jsprm.springboot.app.item.service;

import com.jsprm.springboot.app.item.client.ProductoClientRest;
import com.jsprm.springboot.app.item.entities.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
public class ItemServiceFeign implements ItemService{

    private final ProductoClientRest clienteFeign;

    @Autowired
    public ItemServiceFeign(ProductoClientRest clienteFeign) {
        this.clienteFeign = clienteFeign;
    }

    @Override
    public List<Item> buscarTodos() {
        return clienteFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item buscarPorId(Long id, Integer cantidad) {
        return new Item(clienteFeign.detalle(id), cantidad);
    }
}
