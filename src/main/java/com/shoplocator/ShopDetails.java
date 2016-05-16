package com.shoplocator;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
public class ShopDetails {

    private String shopName;
    private ShopAddress shopAddress;
    private float shopLongitude;
    private float shopLatitude;

    public ShopDetails(String shopName, String addressNumber, String postcode, float longitude, float latitude) {
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

    public float getShopLongitude() {
        return shopLongitude;
    }

    public float getShopLatitude() {
        return shopLatitude;
    }

    public static class Builder {
        private String shopName;
        private String addressNumber;
        private String postcode;
        private float longitude;
        private float latitude;

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

        public Builder longitude(float longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder latitude(float latitude) {
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
