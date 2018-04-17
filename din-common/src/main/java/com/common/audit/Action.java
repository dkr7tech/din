package com.common.audit;



/**
 * The Enum Action.
 */
public enum Action {

	/** The create. */
	CREATE(1, "CREATE"), 
	
	/** The updated. */
	UPDATE(2, "UPDATE"), 
	
	/** The deleted. */
	DELETE(3, "DELETE"), 
	
	/** The load. */
	LOAD(4, "LOAD");

	/** The id. */
	private final int id;
	
	/** The action type. */
	private final String actionType;

	/**
	 * Instantiates a new action.
	 *
	 * @param id the id
	 * @param actionType the action type
	 */
	private Action(int id, String actionType) {
		this.id = id;
		this.actionType = actionType;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the action type.
	 *
	 * @return the action type
	 */
	public String getActionType() {
		return actionType;
	}

}