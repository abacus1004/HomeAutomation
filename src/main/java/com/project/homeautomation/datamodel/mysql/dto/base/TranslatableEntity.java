package com.project.homeautomation.datamodel.mysql.dto.base;

import java.io.Serializable;

public interface TranslatableEntity extends Serializable {

	Object getEntityId();

	boolean isMasterTable();

	boolean isTransientEntityMasterData();
}
