package com.fabrick.webapp.repository;

import com.fabrick.webapp.entities.StoricoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @author Spagnuolo Roberto on 05/03/20
 */



public interface StoricoRepository extends JpaRepository<StoricoEntity, String>
{

    List<StoricoEntity> findByUserId(String userId);

    List<StoricoEntity> findByData(Date data);


    /* TODO */
}
