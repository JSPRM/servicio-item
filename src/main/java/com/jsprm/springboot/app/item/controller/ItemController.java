package com.jsprm.springboot.app.item.controller;

import com.jsprm.springboot.app.item.entities.models.Item;
import com.jsprm.springboot.app.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(@Qualifier("serviceFeign") ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        List<Item> items = itemService.buscarTodos();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
        return itemService.buscarPorId(id, cantidad);
    }

}
