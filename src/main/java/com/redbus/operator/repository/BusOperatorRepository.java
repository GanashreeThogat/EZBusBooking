package com.redbus.operator.repository;

import com.redbus.operator.entity.BusOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BusOperatorRepository extends JpaRepository<BusOperator, String> {
    List<BusOperator> findByDepartureCityAndArrivalCityAndDepartureDate(String departureCity,
                                                                        String arrivalCity,
                                                                        Date departureDate);
    //you can also use a custom JPL query
    @Query("SELECT bo FROM BusOperator bo " +
            "WHERE bo.departureCity = :departureCity " +
            "AND bo.arrivalCity = :arrivalCity " +
            "AND bo.departureDate = :departureDate")
    List<BusOperator> searchByDepartureAndArrivalAndDate(
            @Param("departureCity") String departureCity,
            @Param("arrivalCity") String arrivalCity,
            @Param("departureDate") Date departureDate
    );

    // Add other query methods as needed
    /*@Query("Select bo from BusOperator where bo.email=:email")
    Optional<BusOperator> searchByEmail(@Param("email")String email);*/
}
