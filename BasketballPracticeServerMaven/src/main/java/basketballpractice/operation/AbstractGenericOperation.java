/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.operation;

import basketballpractice.repository.Repository;
import basketballpractice.repository.db.DBRepository;
import basketballpractice.repository.db.impl.RepositoryDBGeneric;

/**
 * Apstraktna klasa koju nasledjuju sve klase koje rade sa bazom
 * @author Aleksandar
 */
public abstract class AbstractGenericOperation {

    /**
     * Referenca na vezu sa bazom
     */
    protected final Repository repository;

    /**
     * Konstruktor
     */
    public AbstractGenericOperation() {
        this.repository = new RepositoryDBGeneric();
    }

    /**
     * Metoda koja izvrsava operaciju u bazi i sacuvava
     * @param param
     * @throws Exception
     */
    public final void execute(Object param) throws Exception {
        try {
            startTransaction();
            preconditions(param);
            executeOperation(param);
            commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        } finally {
            disconnect();
        }
    }

    private void startTransaction() throws Exception {
        ((DBRepository) repository).connect();
    }

    // Operation-specific method

    /**
     * Metoda koja ispituje da li su ispunjeni potrebni uslovi u bazi
     * @param param
     * @throws Exception
     */
    protected abstract void preconditions(Object param) throws Exception;

    // Operation-specific method

    /**
     * Metoda koja izvrsava operaciju u bazi
     * @param param
     * @throws Exception
     */
    protected abstract void executeOperation(Object param) throws Exception;

    private void commitTransaction() throws Exception {
        ((DBRepository) repository).commit();
    }

    private void rollbackTransaction() throws Exception {
        ((DBRepository) repository).rollback();
    }

    private void disconnect() throws Exception {
        ((DBRepository) repository).disconnect();
    }

}
