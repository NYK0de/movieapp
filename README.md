# movieapp, it is an app to load movies information
This is an android application created with jetpack and jetpack compose, applying clean architecture and multi module

## Features

- Load movies list from the movie db
- List of all the movies with its picture
- Show details of every movie in other screen


## Tech

- [Framework Android]
- [Clean Architecture] To give the application a solid and easy way to scale structure
- [Jetpack] - a set of libraries and tools that allow create robust applications
- [Jetpack Compose] - an UI library to create great User Interfaces
  - [LiveData] - Observable data holder class and lifecycle aware
  - [ViewModel] - To store UI related data
- [Coroutines] - to handle background tasks
- [Retrofit] - awesome library to make http request
- [GSON] - Library to convert JSON to Objects.
- [Dagger Hilt] - A library to do dependency injection in our app


## Requirements

- [Git](https://git-scm.com/) - Git is a free and open source distributed version control system designed to handle everything from small to very large projects with speed and efficiency.
- [Java](https://www.java.com/en/) - Java is a programming language and computing platform first released by Sun Microsystems in 1995. Install Java 8 and Java 11.
- [Android Studio](https://developer.android.com/studio) - Android Studio provides the fastest tools for building apps on every type of Android device. Version Bumblebee | 2021.2.1 Patch 1.

## screenshots


## Installation

Clone the repository.

```bash
git clone https://github.com/NYK0de/movieapp.git
git status
```

You have to install Java 8 and Java 11.

Install Android Studio and then open the project...
Only need to execute the run button and will build the project satisfactory.

Or if you want to build and install via terminal, this are steps:

> Note: Set `Java 11` is required for execute gradle tools.
> Note: The `Physical Device` have to have configure the [Developer Options, Debugging USB](https://developer.android.com/studio/debug/dev-options) and connected the device to laptop.

On Mac or Linux
```bash
./gradlew installDebug
```

On Windows
```bash
gradlew.bat installDebug
```
