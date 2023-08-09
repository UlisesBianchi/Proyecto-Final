package com.example.demo.controller;

import com.example.demo.model.Categoria;
import com.example.demo.model.Producto;
import org.springframework.http.HttpStatus;
import com.example.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
  @Autowired
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categoria> guardarCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.guardarCategoria(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerTodas() {
        return ResponseEntity.ok(categoriaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCatPorId(@PathVariable Integer id) {
        Categoria categoria = categoriaService.obtenerCatPorId(id).orElse(null);

        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        ResponseEntity<Categoria> response = null;
        if (categoria.getId() != null && categoriaService.obtenerCatPorId(categoria.getId()).isPresent())
            response = ResponseEntity.ok(categoriaService.actualizarCategoria(categoria));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }


    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Integer id) {
        categoriaService.eliminarCategoria(id);
    }
}