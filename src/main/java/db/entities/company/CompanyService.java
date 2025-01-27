package db.entities.company;

import db.entities.company.dtos.*;
import db.interfaces.IService;
import org.example.Utils;

import java.time.LocalDate;
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
        List<Company> companyEntities = this.companyDao.getAll();
        return Utils.streamCheck(companyEntities)
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

    public List<CompanyDTO> sortAllCompaniesByName() {
        List<Company> companyEntities = this.companyDao.sortByName();
        return Utils.streamCheck(companyEntities)
                .map(CompanyMapper::toDTO)
                .toList();
    }

    public List<CompanyProfitsDTO> sortByProfits() {
        return this.companyDao.sortByProfits();
    }

    public List<CompanyProfitsDTO> filterByProfits(Double lowerBoundInclusive, Double upperBoundInclusive) {
        return this.companyDao.filterByProfits(lowerBoundInclusive, upperBoundInclusive);
    }

    public List<CompanyProfitsByDateDTO> filterProfitsByDate(LocalDate startDate, LocalDate endDate) {
        return this.companyDao.filterProfitsByDate(startDate, endDate);
    }
}
