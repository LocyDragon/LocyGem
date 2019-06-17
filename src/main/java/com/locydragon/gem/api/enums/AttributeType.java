package com.locydragon.gem.api.enums;

public enum AttributeType {
	IGNORE_ARMOR,DAMAGE,HEALTH_ADD,RANDOM_POTION,ARMOR,IGNORE_DAMAGE,RETURN_DAMAGE;
	public static String getArrtibute(AttributeType type) {
		switch (type) {
			case IGNORE_ARMOR:
				return "破甲";
			case DAMAGE:
				return "伤害";
			case HEALTH_ADD:
				return "吸血";
			case RANDOM_POTION:
				return "毒气";
			case ARMOR:
				return "护甲";
			case IGNORE_DAMAGE:
				return "闪避";
			case RETURN_DAMAGE:
				return "反伤";
			default:
				return null;
		}
	}
}
