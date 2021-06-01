<template>
    <div>
        <img class="absolute" src="../../assets/waves.svg"/>
    </div>
    <div class="relative container mx-auto w-full">
        <slot />
    </div>
</template>

<script lang="ts">

export default {
    name: 'base-container',
    setup() {

    }
}

</script>

<style scoped>

</style>
