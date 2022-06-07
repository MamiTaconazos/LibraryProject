package cat.uvic.teknos.m06.bandhub.domain.repositories.jpa;

import cat.uvic.teknos.m06.bandhub.domain.repositories.RepositoriesDo;
import cat.uvic.teknos.m06.bandhub.domain.models.Country;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JPACountryRepository implements RepositoriesDo<Country, Integer> {
    private final EntityManagerFactory entityManagerFactory;
    public JPACountryRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory=entityManagerFactory;
    }

    private void insert (Country country){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
    }
    private void update(Country country){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(country);
        entityManager.getTransaction().commit();
    }


    @Override
    public void save(Country model) {
        if (model.getCod_country()<=0) {
            insert(model);
        }
        else{
            update(model);
        }

    }


    @Override
    public void delete(Integer id) {
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        var country=GetById(id);
        if(country!=null) {
            country= entityManager.merge(country);
            entityManager.remove(country);
        }
        entityManager.getTransaction().commit();
    }



    @Override
    public Country GetById(Integer id) {
        var entityManager=entityManagerFactory.createEntityManager();
        return entityManager.find(Country.class,id);
    }


    @Override
    public List<Country> GetAll() {
        var entitYManager=entityManagerFactory.createEntityManager();
        var query=entitYManager.createQuery("SELECT country FROM Country country");
        return query.getResultList();
    }
}
