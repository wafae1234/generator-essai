package ma.dxc.repository.specs;

import java.util.Date;

/**
 * 
 * @author MB
 *
 */
public class SearchCriteria {
	private String key;
    private Object value;
    private SearchOperation operation;

    public SearchCriteria() {
    }
/**
 * 
 * @param key : nom du colomn
 * @param value : mot clé à comparer
 * @param operation : operation de comparaison 
 */
    public SearchCriteria(String key, Object value, SearchOperation operation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }

    // getters and setters, equals(), toString()

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public SearchOperation getOperation() {
        return operation;
    }

    public void setOperation(SearchOperation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", operation=" + operation +
                '}';
    }
}

