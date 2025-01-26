package db.entities.company;

import db.entities.company.dtos.CompanyDTO;
import db.entities.company.dtos.CompanyMapper;
import db.entities.company.dtos.CreateCompanyDTO;
import db.interfaces.IService;
import org.example.Utils;

import java.util.List;

public class CompanyService implements IService<CompanyDTO, CreateCompanyDTO> {
    private static CompanyService instance;

    private final CompanyDAO companyDao;

    private CompanyService() {
        this.companyDao = CompanyDAO.getInstance();
    }

    public static CompanyService getInstance() {
        if (instance == null) {
            instance = new CompanyService();
        }

        return instance;
    }

    @Override
    public void saveOne(CreateCompanyDTO createCompanyDto) {
        Company clientEntity = CompanyMapper.toEntityFromCreateDTO(createCompanyDto);
        this.companyDao.save(clientEntity);
    }

    @Override
    public CompanyDTO getOne(Long id) {
        Company clientEntity = this.companyDao.getById(id);
        return CompanyMapper.toDTO(clientEntity);
    }

    @Override
    public List<CompanyDTO> getAll() {
        List<Company> clientEntities = this.companyDao.getAll();
        return Utils.streamCheck(clientEntities)
                .map(CompanyMapper::toDTO)
                .toList();
    }

    @Override
    public void updateOne(CreateCompanyDTO createCompanyDto) {
        Company clientEntity = CompanyMapper.toEntityFromCreateDTO(createCompanyDto);
        this.companyDao.update(clientEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.companyDao.deleteById(id);
    }
}
