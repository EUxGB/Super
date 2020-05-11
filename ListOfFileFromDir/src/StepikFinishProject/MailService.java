package StepikFinishProject;

import com.sun.source.doctree.StartElementTree;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<SuperClassMail<T>>, MailService123<T> {

    Map<String, List<T>> box = new HashMap<>();


    public <V> List<V> get(Object key){
        if (!box.containsKey(key)) {
            return Collections.<V>emptyList();

        }
        return (List<V>) box.get(key);
    }

    @Override
    public void accept(SuperClassMail<T> superClassMail) {
        if (!box.containsKey(superClassMail.getTo())){
            box.put(superClassMail.getTo(), new ArrayList<>());
        }
        box.get(superClassMail.getTo()).add(superClassMail.getContent());

    }

    public Map<String, List<T>> getMailBox() {
        return box;
    }


}
