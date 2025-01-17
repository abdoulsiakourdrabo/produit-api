package com.produit.produitservice.repository;

import com.produit.produitservice.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
//CELA met en relation notre model produit au repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
