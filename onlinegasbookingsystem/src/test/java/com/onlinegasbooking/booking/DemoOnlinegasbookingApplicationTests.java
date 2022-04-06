package com.onlinegasbooking.booking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlinegasbooking.entity.SurrenderCylinder;
import com.onlinegasbooking.repository.SurrenderCylinderRepository;
import com.onlinegasbooking.service.SurrenderCylinderService;



@RunWith(SpringRunner.class)
@SpringBootTest
class DemoOnlinegasbookingApplicationTests {

	@Autowired
	private SurrenderCylinderService surrenderCylinderService;
	
	@Autowired
	private SurrenderCylinderRepository surrenderCylinderRepository;
	
	

}
