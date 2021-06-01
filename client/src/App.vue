<template>
    <base-container>
        <div class="grid justify-items-center lg:grid-cols-2 gap-4 p-16">

            <div class="w-full">
                <div class="flex-1 font-header">
                    <h1 class="app-title text-6xl font-extrabold tracking-tighter">CONTANTI</h1>
                    <p class="py-5 text-lg text-gray-800 tracking-wider">
                        Acompanhe o valor de compra e venda das principais moedas!
                    </p>
                    <div class="w-full mt-2">
                        <a target="blank" class="w-full" href="https://github.com/thdq/CurrencyApp">
                            <Button label="Documentação" class="rounded-lg shadow-sm w-6/12 bg-documentation-color border-none" icon="pi pi-github" />
                        </a>
                    </div>



                </div>
            </div>

            <Card class="w-full rounded-lg shadow-lg">
                <template #title>
                    Exibição da cotação
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
import Button from 'primevue/button';
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
        Button,
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

.app-title {
  background: linear-gradient(90deg, rgb(255, 77, 77), rgb(249, 203, 40));
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

.font-header {
font-family: 'Inter', sans-serif;
}

.bg-documentation-color {
    background-color: #fe7342!important;
}

</style>
