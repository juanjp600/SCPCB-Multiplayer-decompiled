Function rcon_difficulty%(arg0%)
    server\Field26 = getnamedifficulty(arg0)
    selecteddifficulty = difficulties(arg0)
    Return $00
End Function
