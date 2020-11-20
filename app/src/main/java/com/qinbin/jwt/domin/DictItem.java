package com.qinbin.jwt.domin;

public class DictItem implements Comparable<DictItem> {

	private final String key;
	private final String value;

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public DictItem(String key, String value) {
		if (key == null || value == null) {
			throw new NullPointerException("key or value can't be null");
		}
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(DictItem another) {
		return this.key.compareTo(another.key);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DictItem other = (DictItem) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
