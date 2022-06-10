package cat.uvic.teknos.m06.bandhub.domain.repositories.jpa;

import cat.uvic.teknos.m06.bandhub.domain.models.Author;
import cat.uvic.teknos.m06.bandhub.domain.repositories.RepositoriesDo;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JPAAuthorRepository implements RepositoriesDo<Author, Integer> {
    private final EntityManagerFactory entityManagerFactory;
    public JPAAuthorRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory=entityManagerFactory;
    }

    private void insert (Author author){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
    }
    private void update(Author author){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(author);
        entityManager.getTransaction().commit();
    }


    @Override
    public void save(Author model) {
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
        var author=GetById(id);
        if(author!=null) {
            author= entityManager.merge(author);
            entityManager.remove(author);
        }
        entityManager.getTransaction().commit();
    }



    @Override
    public Author GetById(Integer id) {
        var entityManager=entityManagerFactory.createEntityManager();
        return entityManager.find(Author.class,id);
    }


    @Override
    public List<Author> GetAll() {
        var entitYManager=entityManagerFactory.createEntityManager();
        var query=entitYManager.createQuery("SELECT author FROM Author author");
        return query.getResultList();
    }
}
