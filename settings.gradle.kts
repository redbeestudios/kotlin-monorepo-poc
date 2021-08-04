rootProject.name = "kotlin-monorepo"

include("shared:database")

include("users:abstractions")
include("users:core")
include("users:entities")
include("users:rest")

include("posts:abstractions")
include("posts:core")
include("posts:entities")

include("infrastructure:monolyth")