package db.entities.driver;


import db.entities.driver.dtos.CreateDriverDTO;
import db.entities.driver.dtos.DriverDTO;
import db.entities.driver.dtos.DriverMapper;
import db.entities.driver.dtos.DriverShortDesciptionDTO;
import db.entities.freight.Freight;
import db.entities.freight.dtos.FreightMapper;
import db.interfaces.IService;
import exceptions.InvalidFreighException;
import org.example.Utils;

import java.util.List;
import java.util.Map;

public class DriverService implements IService<DriverDTO, CreateDriverDTO> {
    private static DriverService instance;

    private final DriverDAO driverDao;

    private DriverService() {
        this.driverDao = DriverDAO.getInstance();
    }

    public static DriverService getInstance() {
        if (instance == null) {
            instance = new DriverService();
        }

        return instance;
    }

    @Override
    public void saveOne(CreateDriverDTO createDriverDto) {
        Driver driverEntity = DriverMapper.toEntityFromCreateDTO(createDriverDto);
        this.driverDao.save(driverEntity);
    }

    public void saveOneEntity(Driver driverEntity) {
        this.driverDao.save(driverEntity);
    }

    @Override
    public DriverDTO getOne(Long id) {
        Driver driverEntity = this.driverDao.getById(id);
        return DriverMapper.toDTO(driverEntity);
    }

    public Driver getOneEntity(Long id) {
        return this.driverDao.getById(id);
    }

    @Override
    public List<DriverDTO> getAll() {
        List<Driver> clientEntities = this.driverDao.getAll();
        return Utils.streamCheck(clientEntities)
                .map(DriverMapper::toDTO)
                .toList();
    }

    public List<Driver> getAllEntities() {
        return this.driverDao.getAll();
    }

    @Override
    public void updateOne(CreateDriverDTO createDriverDto) {
        Driver driverEntity = DriverMapper.toEntityFromCreateDTO(createDriverDto);
        this.driverDao.update(driverEntity);
    }

    public void updateOneEntity(Driver driverEntity) {
        this.driverDao.update(driverEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.driverDao.deleteById(id);
    }

    public List<DriverDTO> filterByQualification(EDriverQualification qualification) {
        List<Driver> driverEntities = this.driverDao.filterByQualification(qualification);
        return Utils.streamCheck(driverEntities)
                .map(DriverMapper::toDTO)
                .toList();
    }

    public List<DriverDTO> sortBySalary() {
        List<Driver> driverEntities = this.driverDao.sortBySalary();
        return Utils.streamCheck(driverEntities)
                .map(DriverMapper::toDTO)
                .toList();
    }

    public List<DriverDTO> filterBySalary(Double lowerBoundInclusive, Double upperBoundInclusive) {
        List<Driver> driverEntities = this.driverDao.filterBySalary(lowerBoundInclusive, upperBoundInclusive);
        return Utils.streamCheck(driverEntities)
                .map(DriverMapper::toDTO)
                .toList();
    }

    public Map<DriverShortDesciptionDTO, Double> mapDriversByTotalProfits() {
        return this.driverDao.mapDriversByTotalProfits();
    }

    public Map<DriverShortDesciptionDTO, Long> mapDriversByFreightCount() {
        return this.driverDao.mapDriversByFreightCount();
    }
}
