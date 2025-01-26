package db.entities.client;

import db.entities.client.dtos.ClientDTO;
import db.entities.client.dtos.ClientMapper;
import db.entities.client.dtos.CreateClientDTO;
import db.interfaces.IService;
import org.example.Utils;

import java.util.List;

public class ClientService implements IService<ClientDTO, CreateClientDTO> {
    private static ClientService instance;

    private final ClientDAO clientDao;

    private ClientService() {
        this.clientDao = ClientDAO.getInstance();
    }

    public static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientService();
        }

        return instance;
    }

    @Override
    public void saveOne(CreateClientDTO createClientDto) {
        Client clientEntity = ClientMapper.toEntityFromCreateDTO(createClientDto);
        this.clientDao.save(clientEntity);
    }

    public void saveOneEntity(Client clientEntity) {
        this.clientDao.save(clientEntity);
    }

    @Override
    public ClientDTO getOne(Long id) {
        Client clientEntity = this.clientDao.getById(id);
        return ClientMapper.toDTO(clientEntity);
    }

    public Client getOneEntity(Long id) {
        return this.clientDao.getById(id);
    }

    @Override
    public List<ClientDTO> getAll() {
        List<Client> clientEntities = this.clientDao.getAll();
        return Utils.streamCheck(clientEntities)
                .map(ClientMapper::toDTO)
                .toList();
    }

    public List<Client> getAllEntities() {
        return this.clientDao.getAll();
    }

    @Override
    public void updateOne(CreateClientDTO clientDto) {
        Client clientEntity = ClientMapper.toEntityFromCreateDTO(clientDto);
        this.clientDao.update(clientEntity);
    }

    public void updateOneEntity(Client clientEntity) {
        this.clientDao.update(clientEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.clientDao.deleteById(id);
    }
}
