package com.example.demo.services;
import com.example.demo.entites.User;
import com.example.demo.entites.projet;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface IProjet {
    projet updateProjet(projet p,Long projectId);

    List<projet> GetAllprojet();

    void removeProjet(Long idprojet, User currentUser);

    projet addProjetwithIdUser(projet p, Long idUser);


}
