package com.freddiemac.dropbox.dto;

import java.util.Objects;



/**
f404127 (Ray Dolan)
 */
public class CounterPartyDTO {
	
	private String  id;
	private String  cpRegisteredName;

	private String  counterPartyRegisteredId;
	
	private Boolean active;


	public CounterPartyDTO() {}
	
	public CounterPartyDTO(String rName, String rId, Boolean active) {
		super();
		this.cpRegisteredName = rName;
		this.counterPartyRegisteredId = rId;
		this.active = active;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCpRegisteredName() {
		return cpRegisteredName;
	}

	public void setCpRegisteredName(String cpRegisteredName) {
		this.cpRegisteredName = cpRegisteredName;
	}

	public String getCounterPartyRegisteredId() {
		return counterPartyRegisteredId;
	}

	public void setCounterPartyRegisteredId(String counterPartyRegisteredId) {
		this.counterPartyRegisteredId = counterPartyRegisteredId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "CounterParty [id=" + id + ", cpRegisteredName=" + cpRegisteredName + ", counterPartyRegisteredId="
				+ counterPartyRegisteredId + ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, counterPartyRegisteredId, cpRegisteredName, id);
	}

	
}
