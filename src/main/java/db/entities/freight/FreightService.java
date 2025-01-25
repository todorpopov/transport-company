package db.entities.freight;


import db.interfaces.IService;
import exceptions.InvalidFreighException;
import org.example.Utils;

import java.util.List;

public class FreightService implements IService<FreightDTO> {
    private final FreightDAO freightDao;

    public FreightService(FreightDAO freightDao) {
        this.freightDao = freightDao != null ? freightDao : new FreightDAO();
    }

    @Override
    public void saveOne(FreightDTO freightDto) {
        try {
            Freight clientEntity = FreightDTO.toEntity(freightDto);
            this.freightDao.save(clientEntity);
        } catch (InvalidFreighException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public FreightDTO getOne(Long id) {
        Freight clientEntity = this.freightDao.getById(id);
        try {
            return FreightDTO.toDTO(clientEntity);

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
                    return FreightDTO.toDTO(dto);
                } catch (InvalidFreighException e) {
                    System.out.println(e.getMessage());
                    return null;
                }
            })
            .toList();
    }

    @Override
    public void updateOne(FreightDTO freightDto) {
        try {
            Freight clientEntity = FreightDTO.toEntity(freightDto);
            this.freightDao.update(clientEntity);
        } catch (InvalidFreighException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteOne(Long id) {
        this.freightDao.deleteById(id);
    }
}
