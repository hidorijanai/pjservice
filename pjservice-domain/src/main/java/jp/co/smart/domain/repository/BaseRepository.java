package jp.co.smart.domain.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface BaseRepository<T, ID extends Serializable> {

//	public abstract T findOneForUpdate(ID paramID);
//
//    List<T> findPageBySearchCriteria(
//            @Param("criteria") TourInfoSearchCriteria criteria,
//            @Param("pageable") Pageable pageable);
//
//    long countBySearchCriteria(
//            @Param("criteria") TourInfoSearchCriteria criteria
//            );

    public abstract <S extends T> S save(S paramS);

    public abstract <S extends T> Collection<S> save(Collection<S> paramIterable);

    public abstract T findOne(ID paramID);

    public abstract boolean exists(ID paramID);

    public abstract List<T> findAll();

    public abstract List<T> findAll(Collection<ID> paramIterable);

    public abstract long count();

    public abstract void delete(ID paramID);

    public abstract void delete(T paramT);

    public abstract void delete(Collection<? extends T> paramIterable);

    public abstract void deleteAll();

    public abstract Collection<T> findAll(Sort paramSort);

    public abstract Page<T> findAll(Pageable paramPageable);

}
