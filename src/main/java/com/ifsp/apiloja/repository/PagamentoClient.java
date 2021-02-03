package com.ifsp.apiloja.repository;

import java.util.Optional;

import com.ifsp.apiloja.model.InfoStatusOrder;
import com.ifsp.apiloja.model.Order;
import com.ifsp.apiloja.model.Purchase;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("pagamento")
public interface PagamentoClient {

    @RequestMapping(value = "/api/compra/{id}")
    public Optional<InfoStatusOrder> selectInfoStatus(@PathVariable Long id);

    @RequestMapping(value = "/api/compra/{nameCompany}", method = RequestMethod.POST)
    public Purchase makePurchase(@PathVariable Order order, @PathVariable String nameCompany);

}