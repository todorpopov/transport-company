package db.entities.company;

import db.interfaces.IService;
import org.example.Utils;

import java.util.List;

public class CompanyService implements IService<CompanyDTO> {
    private final CompanyDAO companyDao;
    
    public CompanyService(CompanyDAO companyDAO) {
        this.companyDao = companyDAO != null ? companyDAO : new CompanyDAO();
    }

    @Override
    public void saveOne(CompanyDTO companyDto) {
        Company clientEntity = CompanyDTO.toEntity(companyDto);
        this.companyDao.save(clientEntity);
    }

    @Override
    public CompanyDTO getOne(Long id) {
        Company clientEntity = this.companyDao.getById(id);
        return CompanyDTO.toDTO(clientEntity);
    }

    @Override
    public List<CompanyDTO> getAll() {
        List<Company> clientEntities = this.companyDao.getAll();
        return Utils.streamCheck(clientEntities)
                .map(CompanyDTO::toDTO)
                .toList();
    }

    @Override
    public void updateOne(CompanyDTO companyDto) {
        Company clientEntity = CompanyDTO.toEntity(companyDto);
        this.companyDao.update(clientEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.companyDao.deleteById(id);
    }
}
