## Cursor Cloud specific instructions

This is the **Trolley Java SDK** — a pure Java HTTP client library for the Trolley payments API. There are no local services, databases, or containers to run.

### Build & test commands

- **Compile:** `mvn compile -B`
- **Package (skip tests + GPG):** `mvn package -DskipTests -Dgpg.skip=true -B`
- **Run tests:** `mvn test -B` (requires valid API credentials; see below)

Set `JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64` before running Maven commands — the javadoc plugin requires it.

### Integration tests & credentials

All tests under `src/test/java/com/trolley/integration/` are **live integration tests** that call the Trolley API at `api.trolley.com`. They require a `.env` file in the repo root with:

```
ACCESS_KEY=<your-trolley-access-key>
SECRET_KEY=<your-trolley-secret-key>
```

Without valid credentials, all 18 tests will fail with `AuthenticationException`. This is expected behavior — there are no unit tests or mocked tests in this repository.

### JVM config

The `.mvn/jvm.config` file contains `--add-opens` flags required for PowerMock compatibility with modern JDKs. These are picked up automatically by Maven.
