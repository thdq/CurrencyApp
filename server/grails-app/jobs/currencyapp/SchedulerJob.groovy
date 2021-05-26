package currencyapp

class SchedulerJob {

    static triggers = {
      simple repeatInterval: 60000l
    }

    def execute() {

        UpdateCurrenciesServices updateCurrenciesServices = new UpdateCurrenciesServices()

        updateCurrenciesServices.handle()

    }
}
