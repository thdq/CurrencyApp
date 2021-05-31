package currencyapp

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class CurrencyInfo {
    public String name
    public Double buy
    public Double sell
    public Double variation
}

@JsonIgnoreProperties(ignoreUnknown = true)

class Currencies {
    public CurrencyInfo USD
    public CurrencyInfo EUR
    public CurrencyInfo GBP
    public CurrencyInfo ARS
    public CurrencyInfo CAD
    public CurrencyInfo AUD
    public CurrencyInfo JPY
    public CurrencyInfo CNY
    public CurrencyInfo BTC

    public List<CurrencyInfo> getCurrenciesList(){

        List<CurrencyInfo> list = []

        list.add(USD)
        list.add(EUR)
        list.add(GBP)
        list.add(ARS)
        list.add(CAD)
        list.add(AUD)
        list.add(JPY)
        list.add(CNY)
        list.add(BTC)

        return list
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ResultModel {
    Currencies currencies
}

@JsonIgnoreProperties(ignoreUnknown = true)
class CurrenciesModel {
    String by
    Boolean valid_key
    ResultModel results

}