package org.example.interndemo.mappers;

import org.example.interndemo.DTOs.ClientDTO;
import org.example.interndemo.Entities.Client;

public class ClientMapper {
    public static ClientDTO toDto(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFullName(client.getFirstName() + " " + client.getLastName());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setProductCount(client.getProducts().size());
        return clientDTO;
    }
}
