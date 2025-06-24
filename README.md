# Example Detekt - Android Static Analysis with GitHub Actions

[![Detekt Static Analysis](https://github.com/h-nimrod/example-detekt/actions/workflows/detekt.yml/badge.svg)](https://github.com/h-nimrod/example-detekt/actions/workflows/detekt.yml)

This project demonstrates how to integrate **Detekt** static code analysis with **GitHub Actions** for Android development. It provides a complete setup for automated code quality checks on pull requests.

## 🎯 Features

- ✅ **Detekt Integration**: Latest version (1.23.4) with Android-specific rules
- ✅ **GitHub Actions Workflow**: Automated analysis on PR creation
- ✅ **PR Comments**: Automatic posting of analysis results
- ✅ **SARIF Reports**: Integration with GitHub Security tab
- ✅ **Multiple Report Formats**: HTML, XML, Markdown, and plain text
- ✅ **Gradle Integration**: Seamless build process integration

## 📋 What is Detekt?

[Detekt](https://detekt.dev/) is a static code analysis tool for the Kotlin programming language. It operates on the abstract syntax tree provided by the Kotlin compiler and can run on various platforms including Android projects.

### Benefits:
- **Code Quality**: Identifies potential bugs and code smells
- **Consistency**: Enforces coding standards across the team
- **Best Practices**: Suggests improvements following Kotlin conventions
- **Technical Debt**: Calculates and tracks technical debt

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/h-nimrod/example-detekt.git
cd example-detekt
```

### 2. Run Detekt Locally
```bash
./gradlew detekt
```

### 3. View Reports
After running Detekt, you can find reports in:
- **HTML**: `app/build/reports/detekt/detekt.html`
- **XML**: `app/build/reports/detekt/detekt.xml`
- **SARIF**: `app/build/reports/detekt/detekt.sarif`
- **Markdown**: `app/build/reports/detekt/detekt.md`

## 📁 Project Structure

```
example-detekt/
├── .github/workflows/
│   └── detekt.yml                 # GitHub Actions workflow
├── app/
│   ├── build.gradle.kts          # App module build configuration
│   └── src/main/java/...         # Android app source code
├── detekt.yml                     # Detekt configuration file
├── build.gradle.kts              # Project build configuration
└── gradle/libs.versions.toml     # Dependency version management
```

## ⚙️ Configuration Details

### Detekt Configuration (`detekt.yml`)

The project uses a comprehensive Detekt configuration with:

- **Complexity Rules**: Cyclomatic complexity, nested block depth, long methods
- **Code Smell Detection**: Magic numbers, long parameter lists, unused code
- **Naming Conventions**: Function names, variable names, package naming
- **Exception Handling**: Generic exception catching, stack trace printing
- **Style Guidelines**: Line length, formatting, documentation

### GitHub Actions Workflow (`.github/workflows/detekt.yml`)

The workflow automatically:

1. **Triggers on PR**: Runs when pull requests are created or updated
2. **Runs Detekt**: Executes static analysis on Kotlin files
3. **Generates Reports**: Creates multiple format reports
4. **Posts Comments**: Automatically comments on PRs with results
5. **Uploads SARIF**: Integrates with GitHub Security tab
6. **Handles Artifacts**: Saves reports for failed builds

### Build Configuration

#### Project Level (`build.gradle.kts`)
```kotlin
plugins {
    alias(libs.plugins.detekt) apply false
}
```

#### App Level (`app/build.gradle.kts`)
```kotlin
plugins {
    alias(libs.plugins.detekt)
}

// Task-level configuration (new API)
tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        html.required.set(true)
        xml.required.set(true)
        sarif.required.set(true)
        md.required.set(true)
    }
}
```

#### Version Management (`gradle/libs.versions.toml`)
```toml
[versions]
detekt = "1.23.4"

[plugins]
detekt = { id = "io.gitlab.arturbosch.detekt", version.ref = "detekt" }
```

## 🔧 Customization

### Adjusting Detekt Rules

You can customize the `detekt.yml` file to:

- **Enable/Disable Rules**: Set `active: true/false`
- **Adjust Thresholds**: Modify complexity limits, line length, etc.
- **Exclude Paths**: Add test directories or specific files
- **Add Custom Rules**: Include additional rule sets

Example:
```yaml
complexity:
  LongMethod:
    active: true
    threshold: 60  # Adjust method length limit

style:
  MaxLineLength:
    active: true
    maxLineLength: 120  # Adjust line length limit
```

### Workflow Customization

The GitHub Actions workflow can be modified to:

- **Change Triggers**: Modify branches, paths, or events
- **Add Steps**: Include additional checks or notifications
- **Adjust Permissions**: Modify access rights as needed
- **Configure Artifacts**: Change retention or naming

## 📊 Understanding Reports

### Technical Debt Calculation

Detekt calculates technical debt based on:
- **Complexity**: Time to reduce cyclomatic complexity
- **Code Smells**: Time to fix style and maintainability issues
- **Bug Risks**: Time to address potential bugs

### Severity Levels

- **Error**: Critical issues that should be fixed immediately
- **Warning**: Issues that should be addressed
- **Info**: Suggestions for improvement

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Ensure Detekt checks pass
5. Submit a pull request

## 📖 Additional Resources

- [Detekt Official Documentation](https://detekt.dev/)
- [GitHub Actions Documentation](https://docs.github.com/en/actions)
- [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)

## 📄 License

This project is provided as an example and is available under the [MIT License](LICENSE).

---

**Note**: This is a demonstration project showing best practices for integrating Detekt with GitHub Actions in Android development workflows. 