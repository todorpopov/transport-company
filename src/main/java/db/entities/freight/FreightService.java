package db.entities.freight;

import db.entities.freight.dtos.CreateFreightDTO;
import db.entities.freight.dtos.FreightDTO;
import db.entities.freight.dtos.FreightMapper;
import db.interfaces.IService;
import exceptions.InvalidFreighException;
import org.example.Utils;

import java.util.List;

public class FreightService implements IService<FreightDTO, CreateFreightDTO> {
    private final FreightDAO freightDao;

    public FreightService(FreightDAO freightDao) {
        this.freightDao = freightDao;
    }

    @Override
    public void saveOne(CreateFreightDTO createFreightDto) {
        Freight clientEntity = FreightMapper.toEntityFromCreateDTO(createFreightDto);
        this.freightDao.save(clientEntity);
    }

    @Override
    public FreightDTO getOne(Long id) {
        Freight clientEntity = this.freightDao.getById(id);
        try {
            return FreightMapper.toDTO(clientEntity);

        } catch (InvalidFreighException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<FreightDTO> getAll() {
        List<Freight> clientEntities = this.freightDao.getAll();
        return Utils.streamCheck(clientEntities)
                .map(dto -> {
                    try {
                        return FreightMapper.toDTO(dto);
                    } catch (InvalidFreighException e) {
                        System.out.println(e.getMessage());
                        return null;
                    }
                })
                .toList();
    }

    @Override
    public void updateOne(CreateFreightDTO createFreightDto) {
        Freight clientEntity = FreightMapper.toEntityFromCreateDTO(createFreightDto);
        this.freightDao.update(clientEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.freightDao.deleteById(id);
    }
}
