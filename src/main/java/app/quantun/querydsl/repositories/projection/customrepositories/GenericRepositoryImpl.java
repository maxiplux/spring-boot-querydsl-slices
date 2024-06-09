package app.quantun.querydsl.repositories.projection.customrepositories;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenericRepositoryImpl<T> implements GenericRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Slice<T> findAllWithoutCount(EntityPath<T> entityPath, Predicate predicate, Pageable pageable) {
        final Querydsl querydsl = new Querydsl(entityManager,
                new PathBuilder<>(entityPath.getType(), entityPath.getMetadata()));

        final int oneMore = pageable.getPageSize() + 1;


        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);

        final JPAQuery<T> query = jpaQueryFactory.selectFrom(entityPath)
                .where(predicate)
                .offset(pageable.getOffset())
                .limit(oneMore);

        final JPQLQuery<T> querySorted = querydsl.applySorting(pageable.getSort(), query);

        final List<T> entities = querySorted.fetch();


        boolean hasNext = entities.size() > pageable.getPageSize();
        return new SliceImpl<>(hasNext ? entities.subList(0, pageable.getPageSize()) : entities, pageable, hasNext);
    }





}
