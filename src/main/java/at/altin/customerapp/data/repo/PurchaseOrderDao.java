package at.altin.customerapp.data.repo;

import at.altin.customerapp.data.BaseDao;
import at.altin.customerapp.model.PurchaseOrder;
import org.springframework.stereotype.Repository;

/**
 * @author altin
 * @since 09.04.2023
 * @version 1.0
 * @see PurchaseOrder
 */
@Repository
public interface PurchaseOrderDao extends BaseDao<PurchaseOrder, Long> {
}
