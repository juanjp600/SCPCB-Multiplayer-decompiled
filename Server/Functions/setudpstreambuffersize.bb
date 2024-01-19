Function setudpstreambuffersize%(arg0%, arg1%)
    Local local0%
    local0 = createbank($04)
    pokeint(local0, $00, arg1)
    setsockopt(arg0, $FFFF, $1002, local0, $04)
    freebank(local0)
    Return $00
End Function
