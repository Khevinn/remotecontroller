package com.cuscuzcomjava.remotecontroller.controller;

import com.cuscuzcomjava.remotecontroller.entity.Actress;
import com.cuscuzcomjava.remotecontroller.entity.Reserve;
import com.cuscuzcomjava.remotecontroller.service.ActressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actress")
public class ActressController {

    @Autowired
    ActressService service;

    @PostMapping("/create")
    public ResponseEntity<Actress> createActress(@RequestBody Actress actress) throws Exception {
        return ResponseEntity.ok(service.createActress(actress));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Actress>> getAllActresses(){
        return ResponseEntity.ok(service.getAllActresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actress> getActress(@PathVariable Long id){
        return ResponseEntity.ok(service.getActress(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Actress> updateActress(@PathVariable Long id,
        @RequestBody Actress actress) {
        return ResponseEntity.ok(service.updateActress(id, actress));
    }

    @DeleteMapping("/delete")
    public void deleteActress(@RequestParam Long id) {
        service.deleteActress(id);
    }
}