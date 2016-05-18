package com.audit;

import java.util.List;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.security.core.userdetails.User;

public class JaversTest {
public void listPrperties(){
	Javers javers = JaversBuilder.javers().build();
	List<CdoSnapshot> snapshots = javers.findSnapshots(
		    QueryBuilder.byClass(User.class).build());
	for(CdoSnapshot snapshot:snapshots){
		System.out.println("ddddddddd "+snapshot.getPropertyValue("first_name"));	
	}


}
}
