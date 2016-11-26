package model;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */

public class ServiceBean {

    private EmbeddedBean _embedded;

    public EmbeddedBean get_embedded() {
        return _embedded;
    }

    public void set_embedded(EmbeddedBean _embedded) {
        this._embedded = _embedded;
    }

    public static class EmbeddedBean {

        private List<Service> services;

        public List<Service> getServices() {
            return services;
        }

        public void setServices(List<Service> services) {
            this.services = services;
        }


    }
}

