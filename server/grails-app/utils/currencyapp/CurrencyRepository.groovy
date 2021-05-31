package currencyapp

class CurrencyRepository {

    void bulkUpdate(List<CurrencyInfo> listCurrencies){

        Currency.withTransaction {

            listCurrencies.each { currency ->

                def updatedCurrency = Currency.findByNameLike(currency.name)

                if (updatedCurrency) {

                    updatedCurrency.buy = currency.buy
                    updatedCurrency.sell = currency.sell
                    updatedCurrency.variation = currency.variation

                    updatedCurrency.save(flush: true)
                }
            }
        }
    }

    void bulkCreate(List<CurrencyInfo> listCurrencies){

        Currency.withTransaction {
            listCurrencies.each { currency ->

                def newCurrency = new Currency(buy: currency.buy, name: currency.name, sell: currency.sell, variation: currency.variation)

                newCurrency.save()

            }
        }

    }

    boolean hasContent(){

        def currencies = Currency.count()

        if(currencies >= 1) return true
        else return false
    }
}