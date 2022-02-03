package com.freddiemac.dropbox.domain;

import java.util.Objects;

/**
f404127 (Ray Dolan)
 */
//@Document(collection = "CounterParty")
//@CompoundIndex(name = "name_lastName_idx",  unique = true, def = "{'firstName': 1, 'lastName': 1}" )
public class CounterParty {

	private String  id;

	//@Indexed(name = "cpRegisteredName", unique=true)
	private String  cpRegisteredName;

	//@Indexed(name = "counterPartyRegisteredId", unique=true)
	private String  counterPartyRegisteredId;
	
	private Boolean active;


	public CounterParty() {}
	
	public CounterParty(String rName, String rId, Boolean active) {
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CounterParty other = (CounterParty) obj;
		return Objects.equals(active, other.active) && Objects.equals(counterPartyRegisteredId, other.counterPartyRegisteredId)
				&& Objects.equals(cpRegisteredName, other.cpRegisteredName) && Objects.equals(id, other.id);
	}


}
