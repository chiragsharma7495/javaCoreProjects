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
# compile (creates package folders based on `package ExtraCurricularSmallProjects;`)
javac -d . LeastRecentlyUsedCache.java

# run
java ExtraCurricularSmallProjects.LeastRecentlyUsedCache
```

### Notes
- The cache capacity is 3 in `main`, so the oldest entry is evicted after 4 inserts.
- You can change the capacity or the test data in `main` to see different output.

### Example output
```
{daym=98, harry=89, sid=90}
```

## Project: Network Programming (TCP Reverse Echo)
A simple TCP client/server example that reverses each line sent from the client.

### What it shows
- `ServerSocket` and `Socket` basics
- Line-based I/O with `BufferedReader` and `PrintStream`
- Simple request/response loop

### Details
See `NetworkProgramming/README.md` for a full explanation and run steps.

## Future projects
- (Add more Java core examples here)
