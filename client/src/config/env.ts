type EnvType = {
    url: string
}

const url = import.meta.env.API_URL as string || 'http://localhost:8080'

const env: EnvType = {
    url
}

export default env
