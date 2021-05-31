package currencyapp

class SchedulerJob {

    static triggers = {
      simple repeatInterval: 600000l
    }

    void execute() {

        def currenciesServices = new CurrenciesServices()

        currenciesServices.handle()

    }
}
