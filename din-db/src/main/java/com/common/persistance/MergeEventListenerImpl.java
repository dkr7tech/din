package com.common.persistance;

import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.MergeEvent;
import org.hibernate.event.spi.MergeEventListener;

public class MergeEventListenerImpl implements MergeEventListener {

	private static final long serialVersionUID = 1L;
	public static final MergeEventListenerImpl INSTANCE = new MergeEventListenerImpl();

	@Override
	public void onMerge(MergeEvent event) throws HibernateException {
		//super.onMerge(event);
		System.out.println("MergeEventListener1wWWWWWWWWWWWWWWWWWWWWWWWWWWw");

	}

	@Override
	public void onMerge(MergeEvent event, Map copiedAlready) throws HibernateException {
		//super.onMerge(event,copiedAlready);
		System.out.println("MergeEventListener2WWWWWWWWWWWWWw");
	}

}