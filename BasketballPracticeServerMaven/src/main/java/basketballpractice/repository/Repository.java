/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.repository;

import java.util.List;

/**
 * Interfejs koji predstavlja repozitorijum u kojem se cuvaju podaci
 * @author Aleksandar
 * @param <T>
 */
public interface Repository<T> {

    /**
     * Metoda za dodavanje objekta u repozitorijum
     * @param param
     * @throws Exception
     */
    void add(T param) throws Exception;

    /**
     * Metoda za menjanje objekta u repozitorijumu
     * @param param
     * @throws Exception
     */
    void edit(T param) throws Exception;

    /**
     * Metoda za brisanje objekta iz repozitorijuma
     * @param param
     * @throws Exception
     */
    void delete(T param)throws Exception;

    /**
     * Metoda za dobijanje objekta iz repozitorijuma prema njegovom id-ju
     * @param param
     * @return
     * @throws Exception
     */
    T getById(T param) throws Exception;

    /**
     * Metoda za dobijanje svih objekata iz repozitorijuma
     * @param param
     * @return
     * @throws Exception
     */
    public List<T> getAll(T param) throws Exception;
}
