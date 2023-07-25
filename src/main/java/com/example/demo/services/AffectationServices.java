package com.example.demo.services;

import com.example.demo.entites.Affectation;
import com.example.demo.entites.User;
import com.example.demo.repository.AffectationRepo;
import com.example.demo.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AffectationServices implements IAffectation {
    @Autowired
    AffectationRepo affectationRepository ;
    @Autowired
    UserRepo userRepository;


    @Override
    public List<Affectation> getAllAffectations(){

        return affectationRepository.findAll();
    }

    @Override
    public Affectation addAffectation (Affectation affectation , Long idUser) {
        User user = userRepository.findById(idUser).orElse(null);
        affectation .setUser(user);
        return affectationRepository.save(affectation );
    }

    @Override
    public Affectation updateAffectation(Affectation affectation){
        return affectationRepository.save(affectation);
    }

    @Override
    public void deleteAffectation (Long idAffectation) {

        affectationRepository.deleteById(idAffectation);
    }
}