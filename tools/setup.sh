#!/bin/bash

GIT_DIR=$(git rev-parse --git-dir 2> /dev/null)
GIT_ROOT=$(git rev-parse --show-toplevel 2> /dev/null)

echo "Installing git pre-push & pre-commit hook"
echo
mkdir -p "${GIT_DIR}/hooks/"
cp "${GIT_ROOT}/tools/pre-commit" "${GIT_DIR}/hooks/pre-commit" \
  && chmod +x "${GIT_DIR}/hooks/pre-commit"
cp "${GIT_ROOT}/tools/pre-push" "${GIT_DIR}/hooks/pre-push" \
  && chmod +x "${GIT_DIR}/hooks/pre-push"
