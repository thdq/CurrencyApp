package currencyapp

import grails.util.Holders as H

class Env {
    String urlAPI
    String key

    Env(){
        this.urlAPI = H.config.getProperty('env_currency.api_url')
        this.key = H.config.getProperty('env_currency.api_key')
    }

    String getUrlAPI() {
        return urlAPI
    }

    String getKey() {
        return key
    }
}
