package com.onlinegasbooking.service;

import java.util.List;
import com.onlinegasbooking.entity.Cylinder;
import com.onlinegasbooking.entity.SurrenderCylinder;
import com.onlinegasbooking.exception.CylinderNotFoundException;
import com.onlinegasbooking.exception.SurrenderCylinderNotFoundException;

/*********************************************************************************************
 *          @author          Aishwarya Gaiki
 *          Description      It is a SurrenderCylinder - Service class. It provides service 
 *                           methods for adding and updating SurrenderCylinder data.
 *          Version          1.0     
 *          Created Date     11 - March - 2021
 **********************************************************************************************/

public interface SurrenderCylinderService {
	
	public SurrenderCylinder addSurrenderCylinder(SurrenderCylinder surrenderCylinder, Integer cId) throws CylinderNotFoundException;
    public String deleteSurrenderCylinder(SurrenderCylinder surrenderCylinder);
    public SurrenderCylinder updateSurrenderCylinder(SurrenderCylinder surrenderCylinder);
    public List<SurrenderCylinder> viewAllSurrenderedCylinder();
}
