package fr.thmarie.parisf1.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.thmarie.parisf1.model.Driver;
import fr.thmarie.parisf1.payload.DriverRequest;
import fr.thmarie.parisf1.repository.DriverRepository;
import fr.thmarie.parisf1.repository.TeamRepository;
import fr.thmarie.parisf1.service.DriverService;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
	@Autowired
	DriverRepository driverRepository;

	@Autowired
	TeamRepository teamRepository;

	@Override
	public Driver addDriver(DriverRequest driverRequest) {
		Driver driver = new Driver();
		driver.setFirstName(driverRequest.getFirstName());
		driver.setSecondName(driverRequest.getFirstName());
		driver.setTeam(teamRepository.getById(driverRequest.getTeamName()));

		Driver newDriver = driverRepository.save(driver);

		return newDriver;
	}
}
