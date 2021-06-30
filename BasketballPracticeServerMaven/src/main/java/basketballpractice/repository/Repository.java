/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.repository;

import java.util.List;

/**
 *
 * @author Aleksandar
 */
public interface Repository<T> {
    void add(T param) throws Exception;
    void edit(T param) throws Exception;
    void delete(T param)throws Exception;
    T getById(T param) throws Exception;
    public List<T> getAll(T param) throws Exception;
}
