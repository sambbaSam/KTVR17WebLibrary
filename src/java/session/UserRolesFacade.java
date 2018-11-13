package session;

import entity.Reader;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import secure.UserRoles;

/**
 *
 * @author Sanata
 */
@Stateless
public class UserRolesFacade extends AbstractFacade<UserRoles> {

    @PersistenceContext(unitName = "KTVR17WebLibraryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserRolesFacade() {
        super(UserRoles.class);
    }

    public List<UserRoles> findByUser(Reader reader) {
        return em.createQuery("SELECT ur FROM UserRoles ur WHERE ur.reader= :reader")
               .setParameter("reader", reader)
               .getResultList();
    }
    
}
