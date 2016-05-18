package com.shoplocator.vo;


import com.shoplocator.ShopDetails;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
public class ShopVO {
    private String shopName;
    private ShopAddress shopAddress;
    private Double shopLongitude;
    private Double shopLatitude;

    public ShopVO(String shopName, String addressNumber, String postcode, Double shopLongitude, Double shopLatitude) {
        this.shopName = shopName;
        this.shopAddress = new ShopAddress(addressNumber, postcode);
        this.shopLongitude = shopLongitude;
        this.shopLatitude = shopLatitude;
    }

    public ShopVO() {}

    public ShopDetails convertToEntity() {
        return new ShopDetails.Builder()
                .shopName(this.shopName)
                .addressNumber(this.shopAddress.getNumber())
                .postcode(this.shopAddress.getPostcode())
                .build();
    }

    public static class Builder {
        private String shopName;
        private String addressNumber;
        private String postcode;
        private Double shopLongitude;
        private Double shopLatitude;

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

        public Builder shopLongitude(Double longitude) {
            this.shopLongitude = longitude;
            return this;
        }

        public Builder shopLatitude(Double latitude) {
            this.shopLatitude = latitude;
            return this;
        }

        public ShopVO build() {
            return new ShopVO(shopName, addressNumber, postcode, shopLongitude, shopLatitude);
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
