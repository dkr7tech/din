package com.audit;

import java.util.List;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.changetype.ValueChange;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.QueryBuilder;

import com.model.user.Permission;
import com.model.user.User;


public class JaversTest {
	public static void main(String args[]){
		
	}
	
	public static void  compare(){
		Javers javers = JaversBuilder.javers().build();
		User user=new User();
		user.setUserId(1);
		user.setLogin("a");
		User user2=new User();
		user2.setUserId(1);
		user2.setLogin("ab");
		Diff diff =javers.compare(user, user2);
		ValueChange change = diff.getChangesByType(ValueChange.class).get(0);
		
		System.out.println(diff.getChanges().size());
		System.out.println(change.getPropertyName());
		System.out.println(change.getRight().toString());
		
		
	}
	
public void listPrperties(){
	
	Javers javers = JaversBuilder.javers().build();
	List<CdoSnapshot> snapshots = javers.findSnapshots(
		    QueryBuilder.byClass(Permission.class).build());
	for(CdoSnapshot snapshot:snapshots){
		System.out.println("ddddddddd "+snapshot.getPropertyValue("first_name"));	
	}


}
}
