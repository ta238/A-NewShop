package service;


import model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> findAllByOrderId(long id);
}