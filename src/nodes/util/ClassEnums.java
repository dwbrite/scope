package nodes.util;

//This class contains the enumerator for the visibility of fields and functions.
public class ClassEnums {
    public enum Visibility {
        PUBLIC ("+"), PRIVATE ("-"), PROTECTED ("#"), DERIVED ("/"), PACKAGE ("~");
        private final String identifier;
        Visibility(String identifier){
            this.identifier = identifier;
        }

        @Override
        public String toString() {
            return identifier;
        }
    }

}
