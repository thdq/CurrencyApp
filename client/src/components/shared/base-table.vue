<template>
    <div>
        <DataTable :value="computedList" responsiveLayout="scroll">
            <Column field="name" header="Nome">
                    <template v-if="loading" #body>
                        <Skeleton></Skeleton>
                    </template>
            </Column>
            <Column field="buyIntl" header="Compra">
                    <template v-if="loading" #body>
                        <Skeleton></Skeleton>
                    </template>
            </Column>
            <Column field="sellIntl" header="Venda">
                    <template v-if="loading" #body>
                        <Skeleton></Skeleton>
                    </template>
            </Column>
            <Column field="variation" header="Variação">
                    <template v-if="loading" #body>
                        <Skeleton></Skeleton>
                    </template>
                    <template v-else #body="row">
                        <span :class="row?.data?.variation > 0? 'positive-variation' : 'negative-variation'"> {{ row?.data?.variation }} </span>
                    </template>
            </Column>
        </DataTable>
    </div>
</template>

<script lang="ts">

import DataTable from 'primevue/datatable';
import Skeleton from 'primevue/skeleton';
import Column from 'primevue/column';
import { computed } from 'vue';


export default {
    name: 'base-table',
    props: {
        list: {
            type: Array,
            default: () => ([])
        },
        loading: {
            type: Boolean,
            default: false
        }
    },
    components: {
      DataTable,
      Column,
      Skeleton
    },
    setup(props) {


        const computedList = computed(() => {

            const skeletonList = new Array(4)
            const hasContentList = props.list.length > 0? true : false

            return hasContentList? props.list : skeletonList
        })

        return {
            computedList
        }

    }
}

</script>

<style scoped>

.negative-variation {
    @apply border-red-600 border-2 rounded-md py-1 px-2 text-red-600 bg-red-100
}

.positive-variation {
    @apply border-green-600 border-2 rounded-md py-1 px-2 text-green-600 bg-green-100
}

</style>
