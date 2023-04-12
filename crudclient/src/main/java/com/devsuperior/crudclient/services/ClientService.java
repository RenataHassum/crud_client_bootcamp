package com.devsuperior.crudclient.services;

import com.devsuperior.crudclient.dtos.ClientDto;
import com.devsuperior.crudclient.entities.Client;
import com.devsuperior.crudclient.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDto> findAll(PageRequest pageRequest) {
        Page<Client> list = repository.findAll(pageRequest);
        return list.map(client -> new ClientDto(client));
    }
}
