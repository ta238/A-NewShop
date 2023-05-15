package service;

import dto.OrderDTO;
import model.CartItem;
import model.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {
    void saveOrderDetail(long orderId, CartItem cartItem);

    Order save(String email, OrderDTO dto);

    List<Order> findAll();

    Order findById(long id);

    Page<model.Order> pageFindAll(int pageNumber, String sortField, String sortDir);

    long countOrder();
}