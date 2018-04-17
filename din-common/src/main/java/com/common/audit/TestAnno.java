package com.common.audit;

@Audit(Auditor.class)
public class TestAnno {
	  public void print() {
		  System.out.println(" called  teatAnno" );
	  }
}
