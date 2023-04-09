package at.altin.customerapp.data.repo;

import at.altin.customerapp.data.BaseDao;
import at.altin.customerapp.model.Promotion;
import org.springframework.stereotype.Repository;

/**
 * @author altin
 * @since 2023
 * @version 1.0
 * @see Promotion
 */
@Repository
public interface PromotionDao extends BaseDao<Promotion, Long> {
}
