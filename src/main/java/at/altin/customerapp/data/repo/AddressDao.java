package at.altin.customerapp.data.repo;

import at.altin.customerapp.data.BaseDao;
import at.altin.customerapp.model.Address;
import org.springframework.stereotype.Repository;

/**
 * @author altin
 * @since 09.04.2023
 * @version 1.0
 * @see Address
 */
@Repository
public interface AddressDao extends BaseDao<Address, Long> {
}
