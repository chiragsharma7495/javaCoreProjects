# Producer Consumer Problem (Java)

This example implements the classic producer-consumer pattern using `synchronized`, `wait()`, and `notify()` on a shared resource.

## What It Demonstrates
- A single-slot buffer shared between one producer and one consumer
- Thread coordination with `wait()` and `notify()`
- Avoiding race conditions with `synchronized`

## How It Works
- `Multithreading` is the shared resource.
- `produce(int value)` waits while data is already available.
- `consume()` waits while data is not available.
- `producer` and `consumer` run in separate threads and call these methods.

## How To Run
1. Compile:

```bash
javac ProducerConsumerProblem/code.java
```

2. Run:

```bash
java ProducerConsumerProblem.code
```

## Expected Output (Sample)
```
produced 1
consumed 1
produced 2
consumed 2
...
```

## Notes
- Class and file names are case-sensitive in Java.
- `notify()` wakes a single waiting thread. For multiple producers/consumers, consider `notifyAll()`.