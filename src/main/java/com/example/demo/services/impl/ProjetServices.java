package com.example.demo.services.impl;

import com.example.demo.entites.User;
import com.example.demo.entites.projet;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.projetRepo;
import com.example.demo.services.IProjet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProjetServices implements IProjet {
    @Autowired
    projetRepo projetRepository;

    @Autowired
    UserRepo userRepository;

    @Override
    public projet updateProjet(projet p) {
            return projetRepository.save(p);
    }
    @Override
    public List<projet> GetAllprojet() {
        return projetRepository.findAll();
    }
    @Override
    public void removeProjet(Long idprojet){projetRepository.deleteById(idprojet);}
    @Override
    public projet addProjetwithIdUser(projet p, Long idUser , String nomprojet ) {
        User user = userRepository.findById(idUser).orElse(null);
        p.setUser(user);
        projet projetExistant = projetRepository.findByNomprojet(nomprojet);
        if (projetExistant == null) {
            projet nouveauProjet = new projet();
            nouveauProjet.setNomprojet(nomprojet);
            nouveauProjet.setUser(user);
            return projetRepository.save(nouveauProjet);
        } else {
            // Le projet existe déjà, vous pouvez choisir de lever une exception, de renvoyer un message, etc.
            return null;
        }
    }

}
