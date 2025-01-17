package com.produit.produitservice.service;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
//creer un produit
    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }
//recupere un produit
    public Produit getProduitById(long id) {
        Optional<Produit>optionalProduit=produitRepository.findById(id);
        //si le produit existe pas exception
        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Désole produit inexistant");
        }
        return optionalProduit.get();
    }

    //supprimer produit

    public String deleteProduitById(long idProduit) {
        Optional<Produit>optionalProduit=produitRepository.findById(idProduit);
        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Suppression impossible :PRODUIT INEXISTANT ");
        }
        produitRepository.delete(optionalProduit.get());
        return "Produit supprime avec succes !";
    }

    public Produit modifierProduitById(long id, Produit produit) {
        Optional<Produit>optionalProduit=produitRepository.findById(id);
        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Modification  impossible :PRODUIT INEXISTANT ");
        }
        Produit produitAModifier=optionalProduit.get();
        produitAModifier.setNom(produit.getNom());
        produitAModifier.setPrix(produit.getPrix());
         return produitRepository.save(produitAModifier);
    }
}
