package service.impl;

import model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderDetailRepository;
import service.OrderDetailService;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public List<OrderDetail> findAllByOrderId(long id) {
        return orderDetailRepository.findAllByOrderId(id);
    }
}