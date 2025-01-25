package db.entities.client;

import db.interfaces.IService;
import org.example.Utils;

import java.util.List;

public class ClientService implements IService<ClientDTO> {
    private final ClientDAO clientDao;

    public ClientService(ClientDAO clientDAO) {
        this.clientDao = clientDAO != null ? clientDAO : new ClientDAO();
    }

    @Override
    public void saveOne(ClientDTO clientDto) {
        Client clientEntity = ClientDTO.toEntity(clientDto);
        this.clientDao.save(clientEntity);
    }

    @Override
    public ClientDTO getOne(Long id) {
        Client clientEntity = this.clientDao.getById(id);
        return ClientDTO.toDTO(clientEntity);
    }

    @Override
    public List<ClientDTO> getAll() {
        List<Client> clientEntities = this.clientDao.getAll();
        return Utils.streamCheck(clientEntities)
                .map(ClientDTO::toDTO)
                .toList();
    }

    @Override
    public void updateOne(ClientDTO clientDto) {
        Client clientEntity = ClientDTO.toEntity(clientDto);
        this.clientDao.update(clientEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.clientDao.deleteById(id);
    }
}
