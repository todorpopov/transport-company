package db.entities.vehicle;

import db.entities.vehicle.dtos.CreateVehicleDTO;
import db.entities.vehicle.dtos.VehicleDTO;
import db.entities.vehicle.dtos.VehicleMapper;
import db.interfaces.IService;
import org.example.Utils;

import java.util.List;

public class VehicleService implements IService<VehicleDTO, CreateVehicleDTO> {
    private final VehicleDAO vehicleDao;

    public VehicleService(VehicleDAO vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    @Override
    public void saveOne(CreateVehicleDTO createVehicleDto) {
        Vehicle vehicleEntity = VehicleMapper.toEntityFromCreateDTO(createVehicleDto);
        this.vehicleDao.save(vehicleEntity);
    }

    @Override
    public VehicleDTO getOne(Long id) {
        Vehicle vehicleEntity = this.vehicleDao.getById(id);
        return VehicleMapper.toDTO(vehicleEntity);
    }

    @Override
    public List<VehicleDTO> getAll() {
        List<Vehicle> vehicleEntities = this.vehicleDao.getAll();
        return Utils.streamCheck(vehicleEntities)
                .map(VehicleMapper::toDTO)
                .toList();
    }

    @Override
    public void updateOne(CreateVehicleDTO createVehicleDto) {
        Vehicle vehicleEntity = VehicleMapper.toEntityFromCreateDTO(createVehicleDto);
        this.vehicleDao.update(vehicleEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.vehicleDao.deleteById(id);
    }
}
