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
        Company company = CompanyMapper.toEntityFromCreateDTO(createCompanyDto);
        this.companyDao.save(company);
    }

    public void saveOneEntity(Company companyEntity) {
        this.companyDao.save(companyEntity);
    }

    @Override
    public CompanyDTO getOne(Long id) {
        Company company = this.companyDao.getById(id);
        return CompanyMapper.toDTO(company);
    }

    public Company getOneEntity(Long id) {
        return this.companyDao.getById(id);
    }

    @Override
    public List<CompanyDTO> getAll() {
        List<Company> clientEntities = this.companyDao.getAll();
        return Utils.streamCheck(clientEntities)
                .map(CompanyMapper::toDTO)
                .toList();
    }

    public List<Company> getAllEntities() {
        return this.companyDao.getAll();
    }

    @Override
    public void updateOne(CreateCompanyDTO createCompanyDto) {
        Company company = CompanyMapper.toEntityFromCreateDTO(createCompanyDto);
        this.companyDao.update(company);
    }

    public void updateOneEntity(Company companyEntity) {
        this.companyDao.update(companyEntity);
    }

    @Override
    public void deleteOne(Long id) {
        this.companyDao.deleteById(id);
    }
}
