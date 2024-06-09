package app.quantun.querydsl.repositories.projection.customrepositories;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface GenericRepository<T> {

    Slice<T> findAllWithoutCount(EntityPath<T> entityPath, Predicate predicate, Pageable pageable);
}
