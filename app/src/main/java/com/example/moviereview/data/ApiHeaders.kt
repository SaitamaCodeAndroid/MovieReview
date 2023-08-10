package com.example.moviereview.data

/**
 * Groups constants related to Stalker API headers.
 */

const val HEADER_TOKEN_REPLACEMENT_SYMBOL = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1MDBjMGU2ZjY5NTAxNTFjY2I3Yzg5Mzk4YzZlZjY3ZiIsInN1YiI6IjYxZTIzNGM2OGNmY2M3MDA0MTI3MDc4YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.066LOP9VdRpgzCnTl5hB1JLeFhQk5UOE9UcnZE1B570"
const val AUTHORIZATION_HEADER_NAME = "Authorization"
const val AUTHORIZATION_HEADER_TYPE_BEARER = "Bearer"
const val BEARER_AUTHORIZATION_HEADER_VALUE =
    "$AUTHORIZATION_HEADER_TYPE_BEARER $HEADER_TOKEN_REPLACEMENT_SYMBOL"
const val BEARER_AUTHORIZATION_HEADER_FULL =
    "$AUTHORIZATION_HEADER_NAME: $BEARER_AUTHORIZATION_HEADER_VALUE"