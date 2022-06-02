package com.jsprm.springboot.app.item.service;

import com.jsprm.springboot.app.item.entities.models.Item;

import java.util.List;

public interface ItemService {
    List<Item> buscarTodos();
    Item buscarPorId(Long id, Integer cantidad);
}
