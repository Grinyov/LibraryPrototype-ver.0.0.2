package com.grinyov.library.dao;

import java.util.List;

import com.grinyov.library.beans.Pager;
import com.grinyov.library.entity.Author;
import com.grinyov.library.entity.Book;
import com.grinyov.library.entity.Genre;
import com.grinyov.library.entity.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Grinyov Vitaliy on 15.10.15.
 *
 * Класс, отвечающий за связь с базой данных и выполнение запросов к ней
 *
 * Запросы строятся через критерии. Транзанкции открываются и закрываются через фильтр в классе HibernateSession
 */
public class Dao {

    private SessionFactory sessionFactory = null;
    private static Dao dataHelper;
    private DetachedCriteria currentCriteria;
    private Pager currentPager;

    private Dao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static Dao getInstance() {
        if (dataHelper == null) {
            dataHelper = new Dao();
        }
        return dataHelper;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Genre> getAllGenres() {
        return getSession().createCriteria(Genre.class).list();
    }

    public List<Author> getAllAuthors() {
        return getSession().createCriteria(Author.class).list();
    }

    public Author getAuthor(long id) {
        return (Author) getSession().get(Author.class, id);
    }

    public void getAllBooks(Pager pager) {
        currentPager = pager;

        Criteria criteria = getSession().createCriteria(Book.class);
        Integer total = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
        currentPager.setTotalBooksCount(total);

        currentCriteria = DetachedCriteria.forClass(Book.class);
        runCurrentCriteria();

    }

    public void getBooksByGenre(Long genreId, Pager pager) {
        currentPager = pager;

        Criterion criterion = Restrictions.eq("genre.id", genreId);

        Criteria criteria = getSession().createCriteria(Book.class);
        Integer total = (Integer) criteria.add(criterion).setProjection(Projections.rowCount()).uniqueResult();
        currentPager.setTotalBooksCount(total);

        currentCriteria = DetachedCriteria.forClass(Book.class);
        currentCriteria.add(criterion);

        runCurrentCriteria();
    }

    public void getBooksByLetter(Character letter, Pager pager) {
        currentPager = pager;

        Criterion criterion = Restrictions.ilike("name", letter.toString(), MatchMode.START);

        Criteria criteria = getSession().createCriteria(Book.class);
        Integer total = (Integer) criteria.add(criterion).setProjection(Projections.rowCount()).uniqueResult();
        currentPager.setTotalBooksCount(total);

        currentCriteria = DetachedCriteria.forClass(Book.class);
        currentCriteria.add(criterion);

        runCurrentCriteria();
    }

    public void getBooksByAuthor(String authorName, Pager pager) {
        currentPager = pager;

        Criterion criterion = Restrictions.ilike("author.fio", authorName, MatchMode.ANYWHERE);

        Criteria criteria = getSession().createCriteria(Book.class, "book").createAlias("book.author", "author");
        Integer total = (Integer) criteria.add(criterion).setProjection(Projections.rowCount()).uniqueResult();
        currentPager.setTotalBooksCount(total);

        currentCriteria = DetachedCriteria.forClass(Book.class, "book").createAlias("book.author", "author");;
        currentCriteria.add(criterion);

        runCurrentCriteria();
    }

    public void getBooksByName(String bookName, Pager pager) {
        currentPager = pager;

        Criterion criterion = Restrictions.ilike("name", bookName, MatchMode.ANYWHERE);
        Criteria criteria = getSession().createCriteria(Book.class);
        Integer total = (Integer) criteria.add(criterion).setProjection(Projections.rowCount()).uniqueResult();
        currentPager.setTotalBooksCount(total);


        currentCriteria = DetachedCriteria.forClass(Book.class);
        currentCriteria.add(criterion);

        runCurrentCriteria();
    }

    public byte[] getContent(Long id) {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.setProjection(Property.forName("content"));
        criteria.add(Restrictions.eq("id", id));
        return (byte[]) criteria.uniqueResult();
    }

    public void runCurrentCriteria() {
        Criteria criteria = currentCriteria.addOrder(Order.asc("name")).getExecutableCriteria(getSession());
        List<Book> list = criteria.setFirstResult(currentPager.getFrom()).setMaxResults(currentPager.getTo()).list();
        currentPager.setList(list);
    }
}
