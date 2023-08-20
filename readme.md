# VaultWrapper

VaultWrapper is a kotlin wrapper for the Vault plugin allowing for easy
use of the VaultAPI in kotlin, simply shade this library into your plugin
and start using the Economy object in your code, no setup required!

Include it in your project by adding the following to your build.gradle
```kt
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.SuperGlueLib:VaultWrapper:1.0.0")
}
```

The library is designed for kotlin and thus utilises extensions functions
as its preferred usage:
```kt
fun exampleUsage(player: Player, amount: Int) {
    player.getBalance()
    player.canAfford(amount)
    player.withdraw(amount)
    player.deposit(amount) 
}
```

If for whatever reason you don't want to use these, you can use the economy object instead:
```kt
fun exampleUsage2(player: Player, amount: Int) {
    Economy.getBalance(player)
    Economy.canAfford(player, amount)
    Economy.withdraw(player, amount)
    Economy.despoit(player, amount)
}
```