# new-fammulfin
Simple web app for managing family finance

## TODOs
- Refine entity field annotations to declare constraints on content.
- Set authorization on repositories. See:
  - [this SO answer](https://stackoverflow.com/a/50510613)
  - [this SO answer](https://stackoverflow.com/a/17575990)
  - [this SO answer](https://stackoverflow.com/a/56872544)
  - [this SO answer](https://stackoverflow.com/a/21577081)

### Notes on TODOs
`JpaRepository` can be secured with '@PreAuthorize', but this is not a good practice.
Moreover, it prevents access without without a web security context as, e.g., from the command line initializer (here `DataPreloader`).

The right thing to do is:
1. to prevent publication of JPA repositories as services (maybe with `@NoService`);
2. to create "custom" services with proper `@PreAuthorize`.
