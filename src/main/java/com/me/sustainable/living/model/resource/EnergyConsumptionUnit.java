package com.me.sustainable.living.model.resource;

/**
 * An Enum to represent the units in which the consumption of an Energy Resource should be
 * measured/tracked.
 */
public enum EnergyConsumptionUnit {
  LITRES, /* For liquid-resources like LPG, Water, etc., */
  WATTS, /* For electricity. */
  KILOGRAMS /* For solid resources like Coal, Wooden Logs, etc., */
}
