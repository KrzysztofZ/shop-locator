package com.shoplocator.beans;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
public class ShopDetails {

    private String shopName;
    private ShopAddress shopAddress;
    private Double shopLongitude;
    private Double shopLatitude;

    public ShopDetails(String shopName, String addressNumber, String postcode, Double longitude, Double latitude) {
        this.shopName = shopName;
        this.shopAddress = new ShopAddress(addressNumber, postcode);
        this.shopLongitude = longitude;
        this.shopLatitude = latitude;
    }

    public String getShopName() {
        return shopName;
    }

    public ShopAddress getShopAddress() {
        return shopAddress;
    }

    public Double getShopLongitude() {
        return shopLongitude;
    }

    public Double getShopLatitude() {
        return shopLatitude;
    }

    public static class Builder {
        private String shopName;
        private String addressNumber;
        private String postcode;
        private Double longitude;
        private Double latitude;

        public Builder shopName(String shopName) {
            this.shopName = shopName;
            return this;
        }

        public Builder addressNumber(String addressNumber) {
            this.addressNumber = addressNumber;
            return this;
        }

        public Builder postcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public Builder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public ShopDetails build() {
            return new ShopDetails(shopName, addressNumber, postcode, longitude, latitude);
        }
    }

    public static class ShopAddress {
        private final String number;
        private final String postcode;

        public ShopAddress(String addressNumber, String postcode) {
            this.number = addressNumber;
            this.postcode = postcode;
        }

        public String getNumber() {
            return number;
        }

        public String getPostcode() {
            return postcode;
        }
    }
}
