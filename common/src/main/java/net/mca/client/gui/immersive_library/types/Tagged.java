package net.mca.client.gui.immersive_library.types;

import java.util.Set;

public interface Tagged {
    Set<String> tags();

    default boolean hasTag(String filter) {
        for (String tag : tags()) {
            if (tag.equals(filter)) {
                return true;
            }
        }
        return false;
    }

    default boolean hasTag(Set<String> tags) {
        for (String tag : this.tags()) {
            if (tags.contains(tag)) {
                return true;
            }
        }
        return false;
    }
}
