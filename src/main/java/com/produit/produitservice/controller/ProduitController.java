package com.produit.produitservice.controller;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//point entre de api
@RequestMapping("/api/v1/produits")
//injection via les contructeurs, genere un contructeur lors de la compilation

public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
    //recupere tout les infos qui seront dans notre base de donnees
    @GetMapping("/all")
    public List<Produit>getAllProduits(){
        return produitService.getAllProduits();
    }

    @PostMapping
    public Produit  createproduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);

    }
}
