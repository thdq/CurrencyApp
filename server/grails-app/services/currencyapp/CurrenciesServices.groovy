package currencyapp

import org.springframework.web.client.RestTemplate

class CurrenciesServices {
    private String urlAPI
    private String key

    CurrenciesServices(){
        def env = new Env()
        this.urlAPI = env.getUrlAPI()
        this.key = env.getKey()
    }

    void handle(){

        try {

            String fullUrlAPI = String.format("%s?key=%s", this.urlAPI, this.key)

            RestTemplate restTemplate = new RestTemplate();
            def result = restTemplate.getForObject(fullUrlAPI, CurrenciesModel.class);

            this.handleContent(result.results.currencies)


        } catch (Error err) {
            print err.getMessage()
        }

    }

    void handleContent(Currencies currencies){

        List<CurrencyInfo> currenciesList = currencies.getCurrenciesList()

        def currencyRepo = new CurrencyRepository()

        boolean hasContent = currencyRepo.hasContent()

        if(hasContent){
            currencyRepo.bulkUpdate(currenciesList)

        }else {
            currencyRepo.bulkCreate(currenciesList)
        }


    }

}
