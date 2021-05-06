public abstract class FurnitureFactory {
    public FurnitureFactory() {
    }

    public static FurnitureAbstractFactory getFactory(MaterialType materialType){
        switch (materialType){
            case PLASTIC:
                return new PlasticFactory();
            case WOOD:
                return new WoodenFactory();
            default:
                throw new UnsupportedOperationException("This furniture is unsupported");
        }
    }
}
