package com.kodilla.good.patterns.challenges.taskthree.service;

import com.kodilla.good.patterns.challenges.taskthree.data.Order;
import com.kodilla.good.patterns.challenges.taskthree.data.SupplierDto;
import com.kodilla.good.patterns.challenges.taskthree.repository.InformationService;
import com.kodilla.good.patterns.challenges.taskthree.repository.ShipmentRepository;
import com.kodilla.good.patterns.challenges.taskthree.repository.SupplierDaoRepository;

public class OrderProcessService {

    private final InformationService informationService;
    private final ShipmentRepository shipmentRepository;
    private final SupplierDaoRepository supplierDaoRepository;

    public OrderProcessService(InformationService informationService, ShipmentRepository shipmentRepository, SupplierDaoRepository supplierDaoRepository) {

        this.informationService = informationService;
        this.shipmentRepository = shipmentRepository;
        this.supplierDaoRepository = supplierDaoRepository;
    }

    public SupplierDto process(Order order){
        boolean isAccepted = shipmentRepository.process(order);
        if (isAccepted){
            informationService.printConfirmation(order);
            supplierDaoRepository.saveOrder(order);
            return new SupplierDto(order.getSupplier(), order,true);
        }else
        {
            return new SupplierDto(order.getSupplier(), order, false);
        }
    }
}
