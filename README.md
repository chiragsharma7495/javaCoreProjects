# Java Core Projects

Small core-Java projects from basic to intermediate.

## Project: Least Recently Used (LRU) Cache
An LRU cache implementation using `LinkedHashMap` with access-order enabled.
When the cache exceeds capacity, the least recently used entry is removed.

### How it works
- Extends `LinkedHashMap`
- Uses access order (`true`) to track recent usage
- Overrides `removeEldestEntry` to enforce capacity

### Run
```bash
# compile
javac LeastRecentlyUsedCache.java

# run
java ExtraCurricularSmallProjects.LeastRecentlyUsedCache
```

### Example output
```
{archita=98, arshiya=89, divam=90}
```

## Future projects
- (Add more Java core examples here)
