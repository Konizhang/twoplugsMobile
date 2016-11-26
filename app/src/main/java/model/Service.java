package model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by koni.zhang on 2016/8/22.
 */

public class Service {

            @SerializedName("userId")
            private String userId;

            private String name;
            private String description;
            private int categoryId;
            private int networkId;
            private int companyId;
            private int price;
            private int refund;
            private int refundValid;
            private int percentage;
            private String payment;
            private String service_type;
            private int sales;
            private int reviews;
            private int type;

            private int status;
            private int active;

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getNetworkId() {
                return networkId;
            }

            public void setNetworkId(int networkId) {
                this.networkId = networkId;
            }

            public int getCompanyId() {
                return companyId;
            }

            public void setCompanyId(int companyId) {
                this.companyId = companyId;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getRefund() {
                return refund;
            }

            public void setRefund(int refund) {
                this.refund = refund;
            }

            public int getRefundValid() {
                return refundValid;
            }

            public void setRefundValid(int refundValid) {
                this.refundValid = refundValid;
            }

            public int getPercentage() {
                return percentage;
            }

            public void setPercentage(int percentage) {
                this.percentage = percentage;
            }

            public String getPayment() {
                return payment;
            }

            public void setPayment(String payment) {
                this.payment = payment;
            }

            public String getService_type() {
                return service_type;
            }

            public void setService_type(String service_type) {
                this.service_type = service_type;
            }

            public int getSales() {
                return sales;
            }

            public void setSales(int sales) {
                this.sales = sales;
            }

            public int getReviews() {
                return reviews;
            }

            public void setReviews(int reviews) {
                this.reviews = reviews;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }


            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getActive() {
                return active;
            }

            public void setActive(int active) {
                this.active = active;
            }
        }
