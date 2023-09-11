# pipeline-projects

The ultimate goal is to create a unified pipeline for projects using different build tools or even tech stacks. The way there may take twists and turns and learning from them.

> Iteration 1

1. Successfully use a build tool/tech-stack specific jenkins file
2. Distill the commonalities to a single jenkins file and have placeholder functions to provide specialized functionality
3. Use yaml or json files to provide additional metadata to help pipeline make smarter decisions
4. Try out unified pipeline with same projects tested previously

> Starting local docker container

docker run --name local-postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d --restart unless-stopped postgres

