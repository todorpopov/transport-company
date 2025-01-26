package db.entities.vehicle;

import db.entities.vehicle.dtos.CreateVehicleDTO;
import db.entities.vehicle.dtos.VehicleDTO;
import db.entities.vehicle.dtos.VehicleMapper;
import db.interfaces.IService;
import org.example.Utils;

import java.util.List;

public class VehicleService implements IService<VehicleDTO, CreateVehicleDTO> {
    private static VehicleService instance;

    private final VehicleDAO vehicleDao;

    private VehicleService() {
        this.vehicleDao = VehicleDAO.getInstance();
    }

    public static VehicleService getInstance() {
        if (instance == null) {
            instance = new VehicleService();
        }

        return instance;
    }

    @Override
    public void saveOne(CreateVehicleDTO createVehicleDto) {
        Vehicle vehicleEntity = VehicleMapper.toEntityFromCreateDTO(createVehicleDto);
        this.vehicleDao.save(vehicleEntity);
    }

    public void saveOneEntity(Vehicle vehicleEntity) {
        this.vehicleDao.save(vehicleEntity);
    }

    @Override
    public VehicleDTO getOne(Long id) {
        Vehicle vehicleEntity = this.vehicleDao.getById(id);
        return VehicleMapper.toDTO(vehicleEntity);
    }

    public Vehicle getOneEntity(Long id) {
        return this.vehicleDao.getById(id);
    }

    @Override
    public List<VehicleDTO> getAll() {
        List<Vehicle> vehicleEntities = this.vehicleDao.getAll();
        return Utils.streamCheck(vehicleEntities)
                .map(VehicleMapper::toDTO)
                .toList();
    }

    public List<Vehicle> getAllEntities() {
        return this.vehicleDao.getAll();
    }

    @Override
    public void updateOne(CreateVehicleDTO createVehicleDto) {
        Vehicle vehicleEntity = VehicleMapper.toEntityFromCreateDTO(createVehicleDto);
        this.vehicleDao.update(vehicleEntity);
    }

    public void updateOneEntity(Vehicle vehicleEntity) {
        this.vehicleDao.update(vehicleEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.vehicleDao.deleteById(id);
    }
}
