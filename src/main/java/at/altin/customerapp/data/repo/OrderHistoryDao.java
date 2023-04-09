package at.altin.customerapp.data.repo;

import at.altin.customerapp.data.BaseDao;
import at.altin.customerapp.model.OrderHistory;
import org.springframework.stereotype.Repository;

/**
 * @author altin
 * @since 09.04.2023
 * @version 1.0
 * @see OrderHistory
 */
@Repository
public interface OrderHistoryDao extends BaseDao<OrderHistory, Long> {
}
