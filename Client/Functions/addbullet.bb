Function addbullet%(arg0%, arg1#, arg2#, arg3%)
    Local local0%
    If (bulletscount >= $C350) Then
        Return $FFFFFFFF
    EndIf
    local0 = (bulletscount * $14)
    pokeint(bulletsbank, (local0 + $00), arg0)
    pokefloat(bulletsbank, (local0 + $04), arg1)
    pokefloat(bulletsbank, (local0 + $08), arg2)
    pokeint(bulletsbank, (local0 + $0C), arg3)
    bulletscount = (bulletscount + $01)
    Return (bulletscount - $01)
    Return $00
End Function
