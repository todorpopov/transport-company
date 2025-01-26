package db.entities.driver;


import db.entities.driver.dtos.CreateDriverDTO;
import db.entities.driver.dtos.DriverDTO;
import db.entities.driver.dtos.DriverMapper;
import db.interfaces.IService;
import org.example.Utils;

import java.util.List;

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
        Driver clientEntity = DriverMapper.toEntityFromCreateDTO(createDriverDto);
        this.driverDao.save(clientEntity);
    }

    @Override
    public DriverDTO getOne(Long id) {
        Driver clientEntity = this.driverDao.getById(id);
        return DriverMapper.toDTO(clientEntity);
    }

    @Override
    public List<DriverDTO> getAll() {
        List<Driver> clientEntities = this.driverDao.getAll();
        return Utils.streamCheck(clientEntities)
                .map(DriverMapper::toDTO)
                .toList();
    }

    @Override
    public void updateOne(CreateDriverDTO createDriverDto) {
        Driver clientEntity = DriverMapper.toEntityFromCreateDTO(createDriverDto);
        this.driverDao.update(clientEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.driverDao.deleteById(id);
    }
}
