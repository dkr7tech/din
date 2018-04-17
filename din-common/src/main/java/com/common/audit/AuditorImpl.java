package com.common.audit;

public class AuditorImpl implements Auditor{

	@Override
	public void doAudit(Action action,Object object) {
		System.out.println("@@@@@@@@@@@@@@  audit"+object.getClass());
		
	}

}
