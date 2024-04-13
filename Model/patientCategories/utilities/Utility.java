package Model.patientCategories.utilities;

import java.util.ArrayList;
import java.util.Arrays;

public class Utility<Type> {
    public final ArrayList<Type> appendElementsToArrayList(ArrayList<Type> list, Type... elements) {
        list.addAll(Arrays.asList(elements));
        list.trimToSize();
        return list;
    }
}
