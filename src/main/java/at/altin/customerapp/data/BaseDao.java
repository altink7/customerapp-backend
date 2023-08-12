package at.altin.customerapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.ManagedBean;
import java.util.Optional;

/**
 * BaseDao for all DAOs.
 * @param <T>
 *     type of the object
 * @param <ID>
 *     id of the object
 *     @see JpaRepository
 */
@ManagedBean
public interface BaseDao<T, ID>  extends JpaRepository<T,ID> {
    /**
     * Delete Object by id.
     * @param id id of the object to delete
     */
    void deleteById(ID id);

    /**
     * Find Object by id.
     * @param id id of the object to find
     * @return Optional of the object
     */
    Optional<T> findById(ID id);

}
