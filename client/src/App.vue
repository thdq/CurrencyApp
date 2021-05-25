<template>
    <base-container>
        <div class="grid justify-items-center bg-gray-100">
            <Card class="w-10/12 rounded-lg shadow-lg mt-8 mb-24">
                <template #title>
                    <img src="./assets/contanti-logo-small.png" class="w-48" />
                </template>
                <template #content>
                    <p>Acompanhe o valor de compra e venda das principais moedas!</p>
                </template>
            </Card>

            <Card class="w-10/12 rounded-lg shadow-lg mb-4">
                <template #title>
                    Exibição
                </template>
                <template #content>
                    <div v-if="apiHandler.error == false">
                        <base-table :list="listCurrencies.values" :loading="apiHandler.waitingResponse" />
                    </div>
                    <div v-else>
                        <InlineMessage class="w-full" severity="error">Ocorreu um erro ao recuperar dados da API. 😢</InlineMessage>
                    </div>
                </template>
            </Card>
        </div>
    </base-container>
</template>

<script lang="ts">
import BaseContainer from "./components/shared/base-container.vue";
import BaseTable from './components/shared/base-table.vue'
import Card from 'primevue/card';
import { onMounted, reactive } from 'vue';
import { CurrencyModel } from './domain/models/currency';
import { CurrencieServices } from './services/currenciesServices';
import InlineMessage from 'primevue/inlinemessage';

interface APIHandlerModel {
    waitingResponse: boolean,
    error: boolean
    errorMessage: string
}

export default {
    name: "App",
    components: {
        BaseContainer,
        BaseTable,
        Card,
        InlineMessage
    },
    setup() {

        const listCurrencies = reactive<CurrencyModel[]>([])

        const apiHandler = reactive<APIHandlerModel>({
            waitingResponse: false,
            error: false,
            errorMessage: ""
        })

        onMounted(async () => {

            try {
                apiHandler.waitingResponse = true

                const currenciesServices = new CurrencieServices()

                listCurrencies.values = await currenciesServices.get() as any

            } catch (error) {
                apiHandler.error = true
            } finally {
                apiHandler.waitingResponse = false
            }



        })

        return {
            listCurrencies,
            apiHandler
        }

    }
}

</script>

<style>
#app {
    background-color: #f3f2f1;
}
</style>
