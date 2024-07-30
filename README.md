# Java Threading Model

Welcome to the comprehensive guide to Java's threading model. This repository covers everything from basic thread lifecycles to advanced concurrency utilities and the latest in virtual threads.

## Table of Contents

- [Introduction](#introduction)
- [Repository Structure](#repository-structure)
  - [ThreadLifecycles](#threadlifecycles)
  - [Concurrency](#concurrency)
    - [ThreadPool](#threadpool)
  - [VirtualThreads](#virtualthreads)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This repository is designed to provide a comprehensive understanding of Java's threading model. It includes examples and explanations of thread states, concurrency utilities, and the new virtual threads introduced in Java.

## Fundamental Computer Hardware Resources
- **CPU**
- **Memory**
- **Disk/SSD**
- **Network**
- **Software Critical Section**

### Sources of Overhead in a Concurrent System
- **Monitors** (i.e., locks and condition variables)
- **Number of context switches**
- **Number of threads**
- **Scheduling**
- **Locality of memory**
- **Algorithm design**

# Repository Structure

### ThreadLifecycles

This folder contains examples demonstrating the various states of a thread in Java. The states covered include:

- **New**: A thread that has been created but not yet started.
- **Runnable**: A thread that is ready to run but waiting for CPU time.
- **Blocked**: A thread that is blocked waiting for a monitor lock.
- **Waiting**: A thread that is waiting indefinitely for another thread to perform a particular action.
- **Timed Waiting**: A thread that is waiting for another thread to perform an action for up to a specified waiting time.
- **Terminated**: A thread that has exited.

Files:
- `NewThread.java`
- `RunnableThread.java`
- `BlockedThread.java`
- `WaitingThread.java`
- `TimedWaitingThread.java`
- `TerminatedThread.java`
- `Main.java`

### Concurrency

This folder contains examples and utilities for managing concurrency in Java.

#### ThreadPool

This subfolder demonstrates the use of thread pools in Java, including the `ThreadPoolExecutor` and custom thread factories.

Files:
- `SimpleThreadPoolExecutor.java`

### VirtualThreads

This folder explores the new virtual threads introduced in Java, providing examples and use cases for lightweight concurrency.

Files:
- `VirtualThreadExample.java`

## Future Enhancements

Because this GitHub repo is meant to be comprehensive, the following folders and examples will eventually be added:

- **Locks and Synchronization**: Examples demonstrating the use of synchronized blocks, locks, and other synchronization primitives.
- **Executor Framework**: Examples showcasing the different types of executors provided by the `java.util.concurrent` package.
- **Fork/Join Framework**: Examples of parallelism using the Fork/Join framework.
- **Reactive Streams**: Examples of using reactive programming and streams for asynchronous programming.
- **Best Practices**: Tips and best practices for writing efficient and safe multithreaded code.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your additions or improvements.

## License

This repository is licensed under the MIT License.
