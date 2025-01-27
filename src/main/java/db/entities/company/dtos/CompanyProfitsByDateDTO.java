package db.entities.company.dtos;

import java.time.LocalDate;

public class CompanyProfitsByDateDTO {
    private Long id;

    private String name;

    private Double profit;

    private LocalDate startDate;

    private LocalDate endDate;

    public CompanyProfitsByDateDTO(Long id, String name, Double profit, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.profit = profit;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "CompanyProfitsByDateDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profit=" + profit +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
