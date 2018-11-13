package session;

import entity.LibHistory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/*@author Sanata */
@Stateless
public class LibHistoryFacade extends AbstractFacade<LibHistory> {

    @PersistenceContext(unitName = "KTVR17WebLibraryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibHistoryFacade() {
        super(LibHistory.class);
    }

    public List<LibHistory> findTakeBooks() { //metod poiska vidannqh knig iz servleta Library.java
        return em.createQuery("SELECT l FROM LibHistory l WHERE l.bookReturn=NULL").getResultList();
    }

}
