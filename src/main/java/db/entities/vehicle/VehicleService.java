package db.entities.vehicle;

import db.interfaces.IService;
import org.example.Utils;

import java.util.List;

public class VehicleService implements IService<VehicleDTO> {
    private final VehicleDAO vehicleDao;

    public VehicleService(VehicleDAO vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    @Override
    public void saveOne(VehicleDTO driverDto) {
        Vehicle vehicleEntity = VehicleDTO.toEntity(driverDto);
        this.vehicleDao.save(vehicleEntity);
    }

    @Override
    public VehicleDTO getOne(Long id) {
        Vehicle vehicleEntity = this.vehicleDao.getById(id);
        return VehicleDTO.toDTO(vehicleEntity);
    }

    @Override
    public List<VehicleDTO> getAll() {
        List<Vehicle> clientEntities = this.vehicleDao.getAll();
        return Utils.streamCheck(clientEntities)
                .map(VehicleDTO::toDTO)
                .toList();
    }

    @Override
    public void updateOne(VehicleDTO driverDto) {
        Vehicle vehicleEntity = VehicleDTO.toEntity(driverDto);
        this.vehicleDao.update(vehicleEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.vehicleDao.deleteById(id);
    }
}
