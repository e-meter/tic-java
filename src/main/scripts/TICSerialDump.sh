#!/bin/bash

# Get script directory
SCRIPT_DIRECTORY=$(dirname "${BASH_SOURCE[0]}")

# Get library directory
LIBRARY_DIRECTORY=$(realpath $SCRIPT_DIRECTORY/..)/lib

# Run executable
java -cp "$LIBRARY_DIRECTORY/*" emeter.tic.cmd.TICSerialDump $*
