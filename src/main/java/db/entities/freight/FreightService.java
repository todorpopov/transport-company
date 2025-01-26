package db.entities.freight;

import db.entities.freight.dtos.CreateFreightDTO;
import db.entities.freight.dtos.FreightDTO;
import db.entities.freight.dtos.FreightMapper;
import db.interfaces.IService;
import exceptions.InvalidFreighException;
import org.example.Utils;

import java.util.List;

public class FreightService implements IService<FreightDTO, CreateFreightDTO> {
    private static FreightService instance;

    private final FreightDAO freightDao;

    private FreightService() {
        this.freightDao = FreightDAO.getInstance();
    }

    public static FreightService getInstance() {
        if (instance == null) {
            instance = new FreightService();
        }

        return instance;
    }

    @Override
    public void saveOne(CreateFreightDTO createFreightDto) {
        Freight freightsEntity = FreightMapper.toEntityFromCreateDTO(createFreightDto);
        this.freightDao.save(freightsEntity);
    }

    public void saveOneEntity(Freight freightsEntity) {
        this.freightDao.save(freightsEntity);
    }

    @Override
    public FreightDTO getOne(Long id) {
        Freight freightsEntity = this.freightDao.getById(id);
        try {
            return FreightMapper.toDTO(freightsEntity);

        } catch (InvalidFreighException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Freight getOneEntity(Long id) {
        return this.freightDao.getById(id);
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

    public List<Freight> getAllEntities() {
        return this.freightDao.getAll();
    }

    @Override
    public void updateOne(CreateFreightDTO createFreightDto) {
        Freight freightsEntity = FreightMapper.toEntityFromCreateDTO(createFreightDto);
        this.freightDao.update(freightsEntity);
    }

    public void updateOneEntity(Freight freightsEntity) {
        this.freightDao.update(freightsEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.freightDao.deleteById(id);
    }

    public Long getNumberOfFreights() {
        return this.freightDao.getNumberOfFreights();
    }

    public Double getTotalFreightProfits() {
        return this.freightDao.getTotalProfits();
    }

    public List<FreightDTO> getAllFreightsSorted() {
        List<Freight> freightEntities = this.freightDao.getAllFreightsSorted();
        return Utils.streamCheck(freightEntities)
                .map(freight -> {
                    try {
                        return FreightMapper.toDTO(freight);
                    } catch (InvalidFreighException e) {
                        System.out.println(e.getMessage());
                        return null;
                    }
                })
                .toList();
    }

    public List<FreightDTO> filterByLocation(String keyword) {
        List<Freight> freightEntities = this.freightDao.filterByLocation(keyword);
        return Utils.streamCheck(freightEntities)
                .map(freight -> {
                    try {
                        return FreightMapper.toDTO(freight);
                    } catch (InvalidFreighException e) {
                        System.out.println(e.getMessage());
                        return null;
                    }
                })
                .toList();
    }
}
