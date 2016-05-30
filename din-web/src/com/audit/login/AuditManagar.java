package com.audit.login;

import java.util.List;

import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.core.diff.Diff;
import org.javers.core.diff.changetype.ValueChange;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.QueryBuilder;

import com.model.user.Role;

public class AuditManagar {
	
	Javers javers;
	
	
	
	
	public AuditManagar(Javers javers) {
		super();
		this.javers = javers;
	}


	public void listPrperties(){
		List<CdoSnapshot> snapshots = javers.findSnapshots(
			    QueryBuilder.byClass(Role.class).build());
		int size=snapshots.size();
		int count=0;
		for(CdoSnapshot snapshot:snapshots){
			List<String> changedList=snapshot.getChanged();
			for(String changedProperty:changedList)
					{
				System.out.println("changed properties name :"+changedProperty +" value :> "+snapshot.getPropertyValue(changedProperty));;
				
					}
			//System.out.println("SNAPSHOT PROPERTY "+snapshot.getPropertyValue("firstName"));	
		}
		printChangeValues(snapshots.get(0),snapshots.get(1));
	}
	
	
	public void printChangeValues(Object oldEntity,Object newEntity){
		 Diff diff = javers.compare(oldEntity, newEntity);

		    //then
		    //there should be one change of type {@link ValueChange}
		 List<ValueChange> listChanges = diff.getChangesByType(ValueChange.class);
		 System.out.println("Propety name      ->   Old Value       ->       New Vallue");
		 for(ValueChange valueChange:listChanges)
		 {
			 
			 System.out.println(valueChange.getPropertyName()+"  ->  "+valueChange.getRight() +"  ->    "+valueChange.getLeft());
		 }
		    ValueChange change = diff.getChangesByType(ValueChange.class).get(0);
		    if(diff.hasChanges()){
		    	List<Change> list =diff.getChanges();
		    	for(Change ch:list){ch.
		    		
		    		System.out.println("changes"+ch.getAffectedObject().get().toString());
		    	}
		    
		    	
		    	List<Change> =diff.getObjectsByChangeType(type)
		    System.out.println("Summery :> "+diff.changesSummary());
		  //  System.out.println(change.getPropertyName()+" oldValue "+change.getLeft() +" new Value "+change.getRight());
		    }
		
	}
}
