package org.example.interndemo.Services;




import org.example.interndemo.DTOs.ClientDTO;
import org.example.interndemo.Entities.Client;
import org.example.interndemo.Repositories.ClientRepository;
import org.example.interndemo.mappers.ClientMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(client -> ClientMapper.toDto(client))
                .toList();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }


    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}

