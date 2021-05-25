import axios from 'axios'
import env from '../config/env'
import { CurrencyModel } from '../domain/models/currency'

export class CurrencieServices {

    async get (): Promise<CurrencyModel[]> {

        try {

            const response = await axios.request({
                url: `${env.url}/currency`
            })



            return this.dataMapper(response.data)




        } catch (error) {
            throw new Error(error.message)
        }

    }

    dataMapper (currencies: CurrencyModel[]): CurrencyModel[] {

        return currencies.map((currencie: CurrencyModel) => {

            currencie.buyIntl = currencie.buy? new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(currencie.buy) : ''
            currencie.sellIntl = currencie.sell? new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(currencie.sell) : ''

            return currencie

        })

    }

}
