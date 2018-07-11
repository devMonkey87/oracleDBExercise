package com.example.implementacionApiRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.implementacionApiRest.entity.Permiso;

public interface IPermisoRepository extends JpaRepository<Permiso, String> {
	
//
//    @Query(value = "  select\r\n" + 
//    		"        permisos0_.role as role3_2_0_,\r\n" + 
//    		"        permisos0_.funcion as funcion1_2_0_,\r\n" + 
//    		"        permisos0_.menu as menu2_2_0_,\r\n" + 
//    		"        permisos0_.funcion as funcion1_2_1_,\r\n" + 
//    		"        permisos0_.menu as menu2_2_1_,\r\n" + 
//    		"        permisos0_.role as role3_2_1_,\r\n" + 
//    		"        permisos0_.acceso as acceso4_2_1_,\r\n" + 
//    		"        permisos0_.tmsins as tmsins5_2_1_,\r\n" + 
//    		"        permisos0_.tmsmod as tmsmod6_2_1_,\r\n" + 
//    		"        permisos0_.usuins as usuins7_2_1_,\r\n" + 
//    		"        permisos0_.usumod as usumod8_2_1_,\r\n" + 
//    		"        funcion1_.funcion as funcion1_0_2_,\r\n" + 
//    		"        funcion1_.menu as menu2_0_2_,\r\n" + 
//    		"        funcion1_.des_funcion as des_funcion3_0_2_,\r\n" + 
//    		"        funcion1_.tipo as tipo4_0_2_,\r\n" + 
//    		"        menu2_.menu as menu1_1_3_,\r\n" + 
//    		"        menu2_.des_menu as des_menu2_1_3_ \r\n" + 
//    		"    from\r\n" + 
//    		"        com_permisos permisos0_ \r\n" + 
//    		"    left outer join\r\n" + 
//    		"        com_funciones funcion1_ \r\n" + 
//    		"            on permisos0_.funcion=funcion1_.funcion \r\n" + 
//    		"            and permisos0_.menu=funcion1_.menu \r\n" + 
//    		"    left outer join\r\n" + 
//    		"        com_menu menu2_ \r\n" + 
//    		"            on funcion1_.menu=menu2_.menu \r\n" + 
//    		"    where\r\n" + 
//    		"        permisos0_.role='R_DESGSA1_DEMO'",
//            nativeQuery=true
//    )
//    public List<Permiso> findByRol();
//}
}
