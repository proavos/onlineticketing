package com.proavos.training.onlinetkt.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class Persistent implements Serializable {

	private static final long serialVersionUID = -4528747516727555914L;

	public Persistent() {
		super();
	}

	@Version
	@Column(name = "VERSION", nullable = false)
	protected Long version = null;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
