package com.locydragon.gem.api.enums;

public enum ElementType {
	WATER,FIRE,WOOD,DARK,LIGHT,EMPTY;
	public static String toElement(ElementType type) {
		switch (type) {
			case DARK:
				return "暗";
			case FIRE:
				return "火";
			case WOOD:
				return "木";
			case LIGHT:
				return "光";
			case WATER:
				return "水";
			case EMPTY:
				return "无";
			default:
				return null;
		}
	}
	public static boolean isCounterBy(ElementType damager, ElementType receiver) {
		switch (receiver) {
			case WATER:
				if (damager == ElementType.WOOD || damager == ElementType.DARK) {
					return true;
				}
				return false;
			case FIRE:
				if (damager == ElementType.WATER || damager == ElementType.DARK) {
					return true;
				}
				return false;
			case WOOD:
				if (damager == ElementType.FIRE || damager == ElementType.DARK) {
					return true;
				}
				return false;
			case DARK:
				if (damager == ElementType.LIGHT) {
					return true;
				}
				return false;
			case LIGHT:
				if (damager == ElementType.FIRE || damager == ElementType.WOOD || damager == ElementType.WATER) {
					return true;
				}
				return false;
		}
		return true;
	}
}
