rootProject.name = "kotlin-monorepo"

include("shared:database")
include("shared:restclient")

include("users:abstractions")
include("users:core")
include("users:entities")
include("users:rest")
include("users:restclient")

include("posts:abstractions")
include("posts:core")
include("posts:entities")
include("posts:rest")

include("infrastructure:monolyth")
include("infrastructure:ms-users")
include("infrastructure:ms-posts")