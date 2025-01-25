package db.entities.driver;


import db.interfaces.IService;
import org.example.Utils;

import java.util.List;

public class DriverService implements IService<DriverDTO> {
    private final DriverDAO driverDao;

    public DriverService(DriverDAO driverDao) {
        this.driverDao = driverDao != null ? driverDao : new DriverDAO();
    }

    @Override
    public void saveOne(DriverDTO driverDto) {
        Driver clientEntity = DriverDTO.toEntity(driverDto);
        this.driverDao.save(clientEntity);
    }

    @Override
    public DriverDTO getOne(Long id) {
        Driver clientEntity = this.driverDao.getById(id);
        return DriverDTO.toDTO(clientEntity);
    }

    @Override
    public List<DriverDTO> getAll() {
        List<Driver> clientEntities = this.driverDao.getAll();
        return Utils.streamCheck(clientEntities)
                .map(DriverDTO::toDTO)
                .toList();
    }

    @Override
    public void updateOne(DriverDTO driverDto) {
        Driver clientEntity = DriverDTO.toEntity(driverDto);
        this.driverDao.update(clientEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.driverDao.deleteById(id);
    }
}
