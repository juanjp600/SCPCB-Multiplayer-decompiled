Function bass_createopusheader%(arg0%, arg1%)
    Local local0%
    local0 = createbank($10D)
    pokebyte(local0, $00, $01)
    pokebyte(local0, $01, arg1)
    pokeshort(local0, $02, $01)
    pokeint(local0, $04, arg0)
    pokeshort(local0, $08, $00)
    Return local0
    Return $00
End Function
