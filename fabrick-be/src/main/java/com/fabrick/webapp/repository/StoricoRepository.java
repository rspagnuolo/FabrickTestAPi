package com.fabrick.webapp.repository;

import com.fabrick.webapp.entities.StoricoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * @author Spagnuolo Roberto on 05/03/20
 */



public interface StoricoRepository extends PagingAndSortingRepository<StoricoEntity, Long>
{
    List<StoricoEntity> findByOperationTypeLike(String descrizione);

    List<StoricoEntity> findByOperationTypeLike(String descrizione, Pageable pageable);

    List<StoricoEntity> findByUserId(String userId);

    List<StoricoEntity> findByData(Date data);


    /* TODO */
}
