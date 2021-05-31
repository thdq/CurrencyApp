package currencyapp

class Currency {
    Long id
    String name
    Double buy
    Double sell
    Double variation

    static constraints = {
        version blank: true, nullable: true
        name blank: true, nullable: true
        buy blank: true, nullable: true
        sell blank: true, nullable: true
        variation blank: true, nullable: true
    }

    static mapping = {
        id generator: 'identity'
    }
}
