#!/bin/bash

set -euo pipefail

IMAGE="${1:?Image is required}"
APP_NAME="${2:?App name is required}"
HOST_PORT="${3:?Host port is required}"
CONTAINER_PORT="${4:?Container port is required}"
DB_PASSWORD="${5:?Db Password required}"
echo "Pulling image: $IMAGE"

podman --remote pull --tls-verify=false "$IMAGE"

echo "Removing previous container..."

podman --remote rm -f "$APP_NAME" || true

echo "Starting application..."

podman --remote secret exists db_password || echo $DB_PASSWORD | podman --remote secret create db_password -

podman --remote run -d \
    --name "$APP_NAME" \
    --restart=always \
    --secret db_password \
    -p "${HOST_PORT}:${CONTAINER_PORT}" \
    "$IMAGE"

echo "Deployment completed!"

podman --remote ps