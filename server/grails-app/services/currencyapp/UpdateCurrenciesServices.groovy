package currencyapp

import org.springframework.http.HttpStatus

class UpdateCurrenciesServices {
    private String urlAPI

    UpdateCurrenciesServices(){
        this.urlAPI = "https://api.hgbrasil.com/finance"
    }

    void handle(){

        try {


        } catch (Error err) {
            print err.getMessage()
        }

    }

}
