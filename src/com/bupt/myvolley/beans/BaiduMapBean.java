package com.bupt.myvolley.beans;

public class BaiduMapBean {
	private String name;
	private Location location;
	private String address;
	private String street_id;
	private String telephone;
	private String uid;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaiduMapBean [name=");
		builder.append(name);
		builder.append(", location=");
		builder.append(location);
		builder.append(", address=");
		builder.append(address);
		builder.append(", street_id=");
		builder.append(street_id);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", uid=");
		builder.append(uid);
		builder.append("]");
		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStreet_id() {
		return street_id;
	}

	public void setStreet_id(String street_id) {
		this.street_id = street_id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public class Location {
		private String lat;

		public String getLat() {
			return lat;
		}

		public void setLat(String lat) {
			this.lat = lat;
		}

		public String getLng() {
			return lng;
		}

		public void setLng(String lng) {
			this.lng = lng;
		}

		private String lng;
	}
}
