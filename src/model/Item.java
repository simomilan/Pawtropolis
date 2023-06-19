package model;

public record Item(String name, String description, int requiredSpace) {                            //ho convertito la classe a record
    @Override                                                                        //patre funzioni, ma è da vedere bene vcos'è questo record
    public String toString () {
        return "Item{"+
                "nameItem='"+name+'\''+
                ", descriptionItem='"+description+'\''+
                ", spaceBagUsed="+requiredSpace+
                '}';
    }


}

