package cat.uvic.teknos.m06.bandhub.domain.repositories.jpa;

import cat.uvic.teknos.m06.bandhub.domain.models.Book;
import cat.uvic.teknos.m06.bandhub.domain.repositories.RepositoriesDo;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JPABookRepository implements RepositoriesDo<Book, Integer> {
    private final EntityManagerFactory entityManagerFactory;
    public JPABookRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory=entityManagerFactory;
    }

    private void insert (Book book){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }
    private void update(Book book){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.getTransaction().commit();
    }


    @Override
    public void save(Book model) {
        if (model.getCod_book()<=0) {
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
        var book=GetById(id);
        if(book!=null) {
            book= entityManager.merge(book);
            entityManager.remove(book);
        }
        entityManager.getTransaction().commit();
    }



    @Override
    public Book GetById(Integer id) {
        var entityManager=entityManagerFactory.createEntityManager();
        return entityManager.find(Book.class,id);
    }


    @Override
    public List<Book> GetAll() {
        var entitYManager=entityManagerFactory.createEntityManager();
        var query=entitYManager.createQuery("SELECT country FROM Country country");
        return query.getResultList();
    }
}
