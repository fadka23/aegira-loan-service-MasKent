# Local run and CI/CD

This repository has one Compose stack at the repository root.

## Run the backend stack

1. Copy `.env.example` to `.env`.
2. Set a long, random `JWT_SECRET`.
3. Run `docker compose up -d --build`.

The API is available at `http://localhost:8080`; PostgreSQL and Redis are included.

## Build the Android application

Android requires an emulator or physical device to run. Compose builds its debug APK with:

```sh
docker compose --profile mobile-build up --build creditappdemomobile-build
```

The APK is stored in the `mobile_apk` Docker volume. To use the backend from an Android emulator, `http://10.0.2.2:8080/` in `NetworkModule.kt` already maps to the host API.

## Register the GitHub self-hosted runner

1. Revoke the runner token shared in the request because it is now exposed, then create a fresh token at **GitHub repository > Settings > Actions > Runners > New self-hosted runner**.
2. Put it in `.env` as `RUNNER_TOKEN`; it is ignored by Git.
3. Start the runner with `docker compose --profile runner up -d runner`.
4. Add a repository Actions secret called `JWT_SECRET`.

The runner receives the `docker-local` label. On a push to `main`, `.github/workflows/ci-cd.yml` tests the backend and Android app, uploads the debug APK, then deploys the backend stack on that runner.

The runner has access to `/var/run/docker.sock`, which grants it control of Docker on the host. Use it only for this trusted repository.
