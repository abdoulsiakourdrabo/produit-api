package com.produit.produitservice.service;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//injection via les contructeurs, genere un contructeur lors de la compilation
@RequiredArgsConstructor
public class ProduitService {

    //comme ca on a lie le service au repository
    private final ProduitRepository produitRepository;

//recupere la liste de tout les produit
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }
}
